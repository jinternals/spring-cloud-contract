package com.jinternsls.stubserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

import static org.springframework.boot.SpringApplication.run;

/**
 * Created by mradul on 19/07/17.
 */
@EnableStubRunnerServer
@SpringBootApplication
@AutoConfigureStubRunner
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

}
