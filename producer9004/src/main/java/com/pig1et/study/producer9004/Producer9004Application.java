package com.pig1et.study.producer9004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.pig1et.study")
@EnableDiscoveryClient
@SpringBootApplication
public class Producer9004Application {

    public static void main(String[] args) {
        SpringApplication.run(Producer9004Application.class, args);
    }

}
