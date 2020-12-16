package com.pig1et.study.nacosserver7006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosServer7006Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosServer7006Application.class, args);
    }

}
