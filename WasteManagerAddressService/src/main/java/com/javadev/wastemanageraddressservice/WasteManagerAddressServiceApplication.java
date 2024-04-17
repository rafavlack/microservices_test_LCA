package com.javadev.wastemanageraddressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
public class WasteManagerAddressServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WasteManagerAddressServiceApplication.class);
        Properties defaults = new Properties();
        defaults.put("spring.profiles.active", "dev");
        app.setDefaultProperties(defaults);
        app.run(args);
    }

}
