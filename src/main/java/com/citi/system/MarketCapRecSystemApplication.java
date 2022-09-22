package com.citi.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MarketCapRecSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext apc= SpringApplication.run(MarketCapRecSystemApplication.class, args);
		
	}

}
