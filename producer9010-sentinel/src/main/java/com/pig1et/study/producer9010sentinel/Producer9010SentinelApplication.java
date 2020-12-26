package com.pig1et.study.producer9010sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Producer9010SentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(Producer9010SentinelApplication.class, args);
	}

}
