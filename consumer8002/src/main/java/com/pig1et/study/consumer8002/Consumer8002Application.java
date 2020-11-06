package com.pig1et.study.consumer8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.pig1et.study")
@EnableEurekaClient
@SpringBootApplication
public class Consumer8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8002Application.class, args);
    }

}
