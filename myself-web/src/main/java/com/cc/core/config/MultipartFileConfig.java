package com.cc.core.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * 配置上传文件的大小限制.
 * @author HeChunXiao
 * @since 2018-12-19 下午 4:34
 */
@SpringBootConfiguration
public class MultipartFileConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置单个数据大小
        factory.setMaxFileSize("10240KB");
        //设置总上传数据大小
        factory.setMaxRequestSize("102400KB");
        return  factory.createMultipartConfig();
    }
}
