package com.sipingsoft.core.config;

import com.sipingsoft.core.shiro.ShiroSessionDao;
import com.sipingsoft.core.util.ApplicationContextUtil;
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
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sipingsoft.core.shiro.ShiroSessionListener;
import com.sipingsoft.core.shiro.UserRealm;


/**
 * shiro配置
 * @author He Chunxiao
 * 官方推荐SpringBoot项目采用SpringBootConfiguration 代替Configuration注解
 */
@SpringBootConfiguration
public class ShiroConfig {

    /**
     * session管理器
     */
	@Bean(name="sessionManager")
	public SessionManager sessionManager(ShiroSessionListener listener, ShiroSessionDao sessionDao){
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		//设置session过期时间(单位：毫秒)，默认为30分钟
		sessionManager.setGlobalSessionTimeout(30*60*1000);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setSessionIdUrlRewritingEnabled(false);
		Collection<SessionListener> listeners = new ArrayList<>();
		listeners.add(listener);
        //session监听器
		sessionManager.setSessionListeners(listeners);
        //session持久化
        //sessionDao.setActiveSessionsCacheName("activeSessionCache");
		//sessionManager.setSessionDAO(sessionDao);
        //session缓存
		sessionManager.setCacheManager(ehCacheManager());
		return sessionManager;
	}

    /**
     * cookie会话模板(使用记住我之后  cookie存放)
     */
	@Bean(name="simpleCookie")
	public SimpleCookie simpleCookie(){
		SimpleCookie simpleCookie = new SimpleCookie();
		simpleCookie.setHttpOnly(true);
        //设置cookie过期时间(单位S) 30天 默认 -1  表示关闭浏览器时失效
		simpleCookie.setMaxAge(2592000);
        //cookie的名字必须
		simpleCookie.setName("simpleCookie");
		return simpleCookie;
	}

    /**
     * rememberManager管理器
     */
	@Bean(name="cookieRememberMeManager")
	public CookieRememberMeManager cookieRememberMeManager( SimpleCookie simpleCookie){
		CookieRememberMeManager cookieRememberMeManager= new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(simpleCookie);
        //加密rememberMe Cookie的密匙(必须是8的整数倍)
		String key = "4AvVhmFLUs0KTA3Kprsdag==";
		cookieRememberMeManager.setCipherKey(key.getBytes());
		return cookieRememberMeManager;
	}

    /**
     * 缓存使用EhCache
     */
	@Bean(name="ehCacheManager")
	public EhCacheManager ehCacheManager(){
		EhCacheManager ehCacheManager = new EhCacheManager();
		ehCacheManager.setCacheManagerConfigFile("classpath:config/ShiroEhCacheConfig.xml");
		return ehCacheManager;
	}

    /**
     * 配置核心安全事务管理器(注册各Manager)
     */
	@Bean
	public SecurityManager securityManager(UserRealm userRealm,SessionManager sessionManager,CookieRememberMeManager cookieRememberMeManager,
			EhCacheManager ehCacheManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //注册自定义的Realm
		securityManager.setRealm(userRealm);
        //注册sesionManager
		securityManager.setSessionManager(sessionManager);
		//注册缓存manager
		securityManager.setCacheManager(ehCacheManager());
		securityManager.setRememberMeManager(cookieRememberMeManager);
		securityManager.setCacheManager(ehCacheManager);
		return securityManager;
	}

	//过滤
	@Bean(name="shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);
		//网站登录的主页
		factoryBean.setLoginUrl("/blog/page/index");
        //没有权限时跳转的地址
		factoryBean.setUnauthorizedUrl("/");

		//LinkedHashMap 为有序的
		Map<String, String> filterMap = new LinkedHashMap<>();
        //静态资源不需要认证
		filterMap.put("/static/**", "anon");
		//管理员登录页面不拦截
        filterMap.put("/back/page/login","anon");
        //登录页请求不拦截
		filterMap.put("/back/login/**","anon");
		//管理员登录请求不拦截
		//filterMap.put("/back/sys/login","anon");
		//filterMap.put("/back/login/checkCode","anon");
        //博客请求不需要验证
        filterMap.put("/blog/api/**","anon");
        filterMap.put("/blog/page/**","anon");

        //使用记住我时必须是user,表示登录和记住我均可访问,不然rememberMe不生效
		//filterMap.put("/**", "user");
        //表示需要身份验证通过才能访问
		filterMap.put("/**", "authc");
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

    /**
     * 扫描上下文
     */
	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
		proxyCreator.setProxyTargetClass(true);
		return proxyCreator;
	}

    /**
     * 加入注解的使用，不加入这个注解不生效
     */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager( securityManager);
		return advisor;
	}


    /**
     * 普通类使用javabean的工具实例
     * @return
     */
	@Bean(name="applicationContextUtil")
    public ApplicationContextUtil applicationContextUtil(){
	    ApplicationContextUtil applicationContextUtil = new ApplicationContextUtil();
	    return applicationContextUtil;
    }

}
