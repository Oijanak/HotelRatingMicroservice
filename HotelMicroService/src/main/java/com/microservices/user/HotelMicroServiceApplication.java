package com.microservices.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "HotelService Api",version = "1.0",description = "hote api get,post"),
					servers = {@Server(url ="http://localhost:8084",description = "Local" )}	,
					tags = @Tag(name = "Hotel Service")

		)
public class HotelMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMicroServiceApplication.class, args);
	}

}
