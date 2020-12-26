package com.pig1et.study.producer9008hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrixDashboard
@EnableHystrix
@ComponentScan("com.pig1et.study")
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Producer9008HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(Producer9008HystrixApplication.class, args);
    }

}
