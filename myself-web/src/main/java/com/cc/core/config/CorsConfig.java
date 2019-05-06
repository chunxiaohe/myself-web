package com.cc.core.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class CorsConfig implements WebMvcConfigurer{

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET","PUT","POST","DELETE", "OPTIONS")
                .allowCredentials(true);
    }*/
}
