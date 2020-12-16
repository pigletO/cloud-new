package com.pig1et.study.nacosserver7005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosServer7005Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosServer7005Application.class, args);
    }

}
