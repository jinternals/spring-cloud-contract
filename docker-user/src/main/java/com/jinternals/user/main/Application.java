package com.jinternals.user.main;

import com.jinternals.commons.logger.LoggerConfig;
import com.jinternals.user.config.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by mradul on 19/07/17.
 */
@SpringBootApplication
@Import({LoggerConfig.class, UserConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
