package com.pig1et.study.consumer8008openfeign.controller;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pig1et.study.consumer8008openfeign.service.HelloProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-06 15:55
 **/
@Slf4j
@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HelloController {

    @Value("${server.ports:#{12345}}")
    private String port;

    private final HelloProducerService helloProducerService;

    @GetMapping("/methodA")
    @HystrixCommand(fallbackMethod = "errorMethod")
    public String methodA(String str) {

        return helloProducerService.methodA(str, port);
    }

    /**
     * @HystrixProperty 取值 参照{@link HystrixCommandProperties#HystrixCommandProperties}
     * @param str
     * @param comeFrom
     * @return
     */
    @HystrixCommand(fallbackMethod = "errorMethod", commandProperties = {
            // 最长等待时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @GetMapping("/methodB")
    public String methodB(String str) {

        return helloProducerService.methodB(str, port);
    }

    public String errorMethod(String str) {
        return "o(╥﹏╥)o!";
    }



}
