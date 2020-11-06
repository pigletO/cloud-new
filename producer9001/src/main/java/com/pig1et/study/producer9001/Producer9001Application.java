package com.pig1et.study.producer9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.pig1et.study")
@EnableEurekaClient
@SpringBootApplication
public class Producer9001Application {

    public static void main(String[] args) {
        SpringApplication.run(Producer9001Application.class, args);
    }

}
