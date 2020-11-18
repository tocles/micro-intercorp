package com.intercorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import com.intercorp.api.ClienteAPI;



@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.intercorp"})

public class SpringMicroApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroApplication.class, args);
	}
}
