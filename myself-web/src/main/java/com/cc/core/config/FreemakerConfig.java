package com.cc.core.config;

import com.cc.core.constants.CommonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author hechunxiao
 */
@Configuration
public class FreemakerConfig {

	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer(CommonProperties commonProperyies){
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("classpath:/templates");
		
		
		Map<String,Object> variables = new HashMap<>();
		variables.put("staticRoot", commonProperyies.getStaticRoot());
		variables.put("webRoot", commonProperyies.getWebRoot());
        variables.put("imagePath",commonProperyies.getImagePath());
		configurer.setFreemarkerVariables(variables);
		
		Properties settings = new Properties();
		settings.setProperty("default_encoding", "utf-8");
		settings.setProperty("number_format", "0.##");
		configurer.setFreemarkerSettings(settings);
		return configurer;
	}
}
