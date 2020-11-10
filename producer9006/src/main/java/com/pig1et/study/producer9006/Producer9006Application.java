package com.pig1et.study.producer9006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.pig1et.study")
@EnableDiscoveryClient
@SpringBootApplication
public class Producer9006Application {

    public static void main(String[] args) {
        SpringApplication.run(Producer9006Application.class, args);
    }

}
