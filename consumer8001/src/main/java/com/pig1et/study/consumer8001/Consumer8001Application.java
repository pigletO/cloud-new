package com.pig1et.study.consumer8001;

import com.pig1et.ribbon.Rule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.pig1et.study"})
// 声明ribbon对哪些微服务使用什么样的轮询策略
@RibbonClients({@RibbonClient(value = "producer", configuration = Rule.class),
                @RibbonClient(value = "producer2", configuration = Rule.class)})
@EnableEurekaClient
@SpringBootApplication
public class Consumer8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8001Application.class, args);
    }

}
