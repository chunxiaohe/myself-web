package com.sipingsoft.core.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="com.sipingsoft")
public class CommonProperties {
	
	private String staticRoot;//static根路径

	private String webRoot;//根路径
	
	private boolean shiroRedisCache; // 是否开启redis缓存
	
	public String getStaticRoot() {
		return staticRoot;
	}

	public void setStaticRoot(String staticRoot) {
		this.staticRoot = staticRoot;
	}

	public boolean isShiroRedisCache() {
		return shiroRedisCache;
	}

	public void setShiroRedisCache(boolean shiroRedisCache) {
		this.shiroRedisCache = shiroRedisCache;
	}

	public String getWebRoot() {
		return webRoot;
	}

	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}
	
	
}
