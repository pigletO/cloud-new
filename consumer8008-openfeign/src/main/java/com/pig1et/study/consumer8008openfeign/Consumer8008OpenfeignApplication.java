package com.pig1et.study.consumer8008openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Consumer8008OpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8008OpenfeignApplication.class, args);
    }

}
