package com.sipingsoft.core.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
//import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sipingsoft.core.shiro.ShiroSessionListener;
import com.sipingsoft.core.shiro.UserRealm;



@Configuration
public class ShiroConfig {

	//session管理器
	@Bean(name="sessionManager")
	public SessionManager sessionManager(ShiroSessionListener listener){
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		//设置session过期时间(单位：毫秒)，默认为30分钟
		sessionManager.setGlobalSessionTimeout(1*60*1000);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setSessionIdUrlRewritingEnabled(false);
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		listeners.add(listener);
		//sessionManager.setSessionListeners(listeners);//session监听器
		//sessionManager.setSessionDAO(sessionDao);//session持久化
		//sessionManager.setCacheManager(cacheManager);//session缓存
		return sessionManager;
	}

	//cookie会话模板
	@Bean(name="simpleCookie")
	public SimpleCookie simpleCookie(){
		SimpleCookie simpleCookie = new SimpleCookie();
		simpleCookie.setHttpOnly(true);
		//simpleCookie.setMaxAge(2592000);//30天(单位S)
		simpleCookie.setMaxAge(-1);//关闭浏览器cookie失效
		simpleCookie.setName("simpleCookie");//cookie的名字必须
		return simpleCookie;
	}

	//rememberManager管理器
	@Bean(name="cookieRememberMeManager")
	public CookieRememberMeManager cookieRememberMeManager( SimpleCookie simpleCookie){
		CookieRememberMeManager cookieRememberMeManager= new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(simpleCookie);
		String key = "4AvVhmFLUs0KTA3Kprsdag==";//加密rememberMe Cookie的密匙(必须是8的整数倍)
		cookieRememberMeManager.setCipherKey(key.getBytes());
		return cookieRememberMeManager;
	}

	//缓存使用EhCache
	@Bean(name="ehCacheManager")
	public EhCacheManager ehCacheManager( ){
		EhCacheManager ehCacheManager = new EhCacheManager();
		ehCacheManager.setCacheManagerConfigFile("classpath:config/ShiroEhCacheConfig.xml");
		return ehCacheManager;
	}
	

	//配置核心安全事务管理器(注册各Manager)
	@Bean
	public SecurityManager securityManager(UserRealm userRealm,SessionManager sessionManager,CookieRememberMeManager cookieRememberMeManager,
			EhCacheManager ehCacheManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);//注册自定义的Realm
		securityManager.setSessionManager(sessionManager);//注册sesionManager
		//securityManager.setCacheManager(cacheManager);
		securityManager.setRememberMeManager(cookieRememberMeManager);
		securityManager.setCacheManager(ehCacheManager);
		return securityManager;
	}

	//过滤
	@Bean(name="shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);
		factoryBean.setLoginUrl("/page/login");
		factoryBean.setUnauthorizedUrl("/");//没有权限时跳转的地址

		Map<String, String> filterMap = new LinkedHashMap<>();
		//filterMap.put("/sysUser/add", "anon"); // 暂时写的
		filterMap.put("/sys/login", "anon"); // 登陆方法
		filterMap.put("/static/**", "anon");//静态资源不需要认证

		//filterMap.put("/**", "authc");//表示需要身份验证通过才能访问
		filterMap.put("/**", "user");//使用记住我时必须是user,表示登录和记住我均可访问,不然rememberMe不生效
		factoryBean.setFilterChainDefinitionMap(filterMap);

		return factoryBean;
	}

	/**
	 * 管理shiro bean的生命周期
	 * @return
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	//扫描上下文
	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
		proxyCreator.setProxyTargetClass(true);
		return proxyCreator;
	}

	//加入注解的使用，不加入这个注解不生效
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager( securityManager);
		return advisor;
	}



}
