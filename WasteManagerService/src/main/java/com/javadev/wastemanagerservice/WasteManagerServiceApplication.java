package com.javadev.wastemanagerservice;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
public class WasteManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WasteManagerServiceApplication.class);
        Properties defaults = new Properties();
        defaults.put("spring.profiles.active", "dev");
        app.setDefaultProperties(defaults);
        app.run(args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }

}
