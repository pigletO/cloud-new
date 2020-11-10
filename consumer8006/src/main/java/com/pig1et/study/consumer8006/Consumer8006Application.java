package com.pig1et.study.consumer8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.pig1et.study")
@EnableDiscoveryClient
@SpringBootApplication
public class Consumer8006Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8006Application.class, args);
    }

}
