package com.example.boottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootTestApplication {
	private static final Logger logger = LoggerFactory.getLogger(BootTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BootTestApplication.class, args);
	}

	@Value("${test.bar:#{null}}")
	private String testBar;
	@Value("${xx}")
	private String test;

	@GetMapping(value = "/testBar")
	public Object test() {
		logger.info("===xxx:{}", test);
		logger.info("==== testBar is null :{}", (testBar == null));
		return testBar;
	}
}
