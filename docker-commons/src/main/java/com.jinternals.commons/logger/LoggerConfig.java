package com.jinternals.commons.logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mradul on 31/01/17.
 */
@Configuration
public class LoggerConfig {

    @Bean
    public LoggerInjectorBeanPostProcessor getLoggerInjectorBeanPostProcessor(){
        return new LoggerInjectorBeanPostProcessor();
    }

}

