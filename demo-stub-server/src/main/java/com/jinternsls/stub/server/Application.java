package com.jinternsls.stub.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

import static org.springframework.boot.SpringApplication.run;

/**
 * Created by mradul on 19/07/17.
 */
@SpringBootApplication
@EnableStubRunnerServer
@AutoConfigureStubRunner
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

}
