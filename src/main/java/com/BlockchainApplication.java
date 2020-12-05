package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.repository")
public class BlockchainApplication {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(BlockchainApplication.class, args);
	}

}
