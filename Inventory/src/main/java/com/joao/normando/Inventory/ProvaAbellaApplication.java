package com.joao.normando.Inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProvaAbellaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaAbellaApplication.class, args);
	}

}
