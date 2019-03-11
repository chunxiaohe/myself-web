package com.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 项目启动类
 * @author He Chunxiao
 * @since 2018-08-05 16:34:25
 */
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan(value = {"com.sipingsoft.back.**.mapper","com.sipingsoft.blog.**.mapper"})
@EnableScheduling
public class MyselfWebApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MyselfWebApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyselfWebApplication.class);
	}
}
