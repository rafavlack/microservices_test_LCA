package com.javadev.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.Properties;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigServerApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(CloudConfigServerApplication.class);
        Properties defaults = new Properties();
        defaults.put("spring.profiles.active", "dev");
        app.setDefaultProperties(defaults);
        app.run(args);
    }

}
