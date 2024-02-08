package com.soapwsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.soapwsapp") // Adjust package accordingly
public class SpringSoapWsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapWsAppApplication.class, args);
	}

}
