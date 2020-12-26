package com.pig1et.study.consumer8010;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@RibbonClients(value = {@RibbonClient(value = "producer", configuration = RandomRule.class)}, defaultConfiguration = RoundRobinRule.class)
@EnableDiscoveryClient
@SpringBootApplication
public class Consumer8010Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8010Application.class, args);
    }

}
