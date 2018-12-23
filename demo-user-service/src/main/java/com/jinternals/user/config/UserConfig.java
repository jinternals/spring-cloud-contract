package com.jinternals.user.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by mradul on 04/11/16.
 */

@Configuration
@EnableMongoRepositories(basePackages = {"com.jinternals.user.repositories"})
public class UserConfig implements WebMvcConfigurer {

}