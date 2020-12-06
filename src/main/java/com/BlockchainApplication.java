package com;

import org.apache.catalina.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BlockchainApplication {

	public static void main(String[] args) {
		// Server webServer = Server.createWebServer("-web,-webAllowOthers,true,-webPort,8082").start();
		SpringApplication.run(BlockchainApplication.class, args);
	}
}
