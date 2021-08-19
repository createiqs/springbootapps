package com.createiq.pw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ECommerceAdminApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ECommerceAdminApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ECommerceAdminApplication.class, args);
		LOGGER.info("Sample Log message with Some Parametres {} {} and {} ",1,2,3);
	//
	}
}
