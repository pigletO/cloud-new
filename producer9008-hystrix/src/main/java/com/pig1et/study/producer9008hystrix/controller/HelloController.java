package com.pig1et.study.producer9008hystrix.controller;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pig1et.study.commonapi.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-06 16:09
 **/
@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private HelloService helloService;

//    @HystrixCommand(fallbackMethod = "errorMethod")
    @GetMapping("say")
    public String MethodA(String str, String comeFrom) {
        log.info("【hello/say】comeFrom:{}", comeFrom);
        return helloService.methodA(str) + "invoke Server:" + port + ",come from Server:" + comeFrom;
    }

    /**
     * @HystrixProperty 取值 参照{@link HystrixCommandProperties#HystrixCommandProperties}
     * @param str
     * @param comeFrom
     * @return
     */
    @HystrixCommand(fallbackMethod = "errorMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
    })
    @GetMapping("timeout")
    public String methodB(String str, String comeFrom) {
        return helloService.methodB(str) + "invoke Server:" + port + ",come from Server:" + comeFrom;
    }

    public String errorMethod(String str, String comeFrom) {
        return Thread.currentThread().getName() + "o(╥﹏╥)o:" + port;
    }
}
