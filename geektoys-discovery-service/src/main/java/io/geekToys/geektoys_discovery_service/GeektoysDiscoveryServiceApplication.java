package io.geekToys.geektoys_discovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Activa el servidor Eureka.
public class GeektoysDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeektoysDiscoveryServiceApplication.class, args);
	}

}
