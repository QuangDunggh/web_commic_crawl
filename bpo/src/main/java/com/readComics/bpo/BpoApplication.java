package com.readComics.bpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("{com.readComics.bpo}")
public class BpoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BpoApplication.class, args);
	}

}
