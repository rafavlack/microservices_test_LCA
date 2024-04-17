package com.javadev.gatewayservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin(origins = "*")
public class GatewayServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GatewayServiceApplication.class);
		Properties defaults = new Properties();
		defaults.put("spring.profiles.active", "dev");
		app.setDefaultProperties(defaults);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Entrando el gateway");
	}
}
