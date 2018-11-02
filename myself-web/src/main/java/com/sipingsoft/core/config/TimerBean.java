package com.sipingsoft.core.config;

import com.sipingsoft.core.timer.SecurityCodeTimer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置类
 * @author HeChunXiao
 * @since 2018-11-02 下午 3:46
 */
@Configuration
public class TimerBean {

    @Bean
    public SecurityCodeTimer securityCodeTimerBean(){
        SecurityCodeTimer securityCodeTimer = new SecurityCodeTimer();
        return securityCodeTimer;
    }
}
