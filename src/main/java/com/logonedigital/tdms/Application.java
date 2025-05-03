package com.logonedigital.tdms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
			logger.info("APPLICATION SUCCESSFULLY STARTED");
		} catch (Exception e) {
			logger.error("ERROR WHILE STARTING APPLICATION: {}", e.getMessage(), e);
			throw e;
		}

	}

}
