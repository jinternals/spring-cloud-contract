package com.jinternals.user.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by mradul on 04/11/16.
 */

@Configuration
@ComponentScan(basePackages = {"com.jinternals.user.controllers","com.jinternals.user.services.impl"})
@EnableMongoRepositories(basePackages = {"com.jinternals.user.repositories"})
public class UserConfig extends WebMvcConfigurerAdapter {


}