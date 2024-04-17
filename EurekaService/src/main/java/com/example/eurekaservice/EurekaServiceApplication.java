package com.example.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Properties;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EurekaServiceApplication.class);
        Properties defaults = new Properties();
        defaults.put("spring.profiles.active", "dev");
        app.setDefaultProperties(defaults);
        app.run(args);
    }

}
