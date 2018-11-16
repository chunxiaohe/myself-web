package com.sipingsoft.core.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件 参数
 * @author He Chunxiao
 */
@Component
@ConfigurationProperties(prefix="com.sipingsoft")
public class CommonProperties {

    /**
     *static根路径
     */
	private String staticRoot;

    /**
     *根路径
     */
	private String webRoot;
	

	public String getStaticRoot() {
		return staticRoot;
	}

	public void setStaticRoot(String staticRoot) {
		this.staticRoot = staticRoot;
	}


	public String getWebRoot() {
		return webRoot;
	}

	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}
	
	
}
