package com.cc.core.config;

import com.cc.core.interceptor.ApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 *
 * 定义路由拦截策略
 *
 * @author HeChunXiao
 * @since 2018-11-08 下午 4:03
 */
@SpringBootConfiguration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ApiInterceptor apiInterceptor;

    /**
     * 配置拦截器需要拦截的请求
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor)
                .addPathPatterns("/page/wechat*/**","/wechat*/**");

    }

    /**
     * 放行静态资源
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //放行js/css等
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        //放行页面
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
    }
}
