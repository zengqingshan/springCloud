package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserApplication.class, args);
	}

}
