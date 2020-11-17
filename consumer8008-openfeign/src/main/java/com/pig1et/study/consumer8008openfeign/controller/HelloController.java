package com.pig1et.study.consumer8008openfeign.controller;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
/**
 * 开启了@DefaultProperties注解之后，以下所有方法只要加了@HystrixCommand都会使用默认配置，
 * 没加@HystrixCommand不启用熔断，如果有单独配置，单独配置优先
 */
@DefaultProperties(defaultFallback = "errorMethod")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HelloController {

    @Value("${server.ports:#{12345}}")
    private String port;

    private final HelloProducerService helloProducerService;

    @HystrixCommand
    @GetMapping("/methodA")
    public String methodA(String str) {

        return helloProducerService.methodA(str, port);
    }

    /**
     * @HystrixProperty 取值 参照{@link HystrixCommandProperties#HystrixCommandProperties}
     * @param str
     * @param comeFrom
     * @return
     */
    @HystrixCommand(commandProperties = {
            // 最长等待时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/methodB")
    public String methodB(String str) {

        return helloProducerService.methodB(str, port);
    }

    @GetMapping("/methodC")
    public String methodC(String str) {

        return helloProducerService.methodA(str, port);
    }

    public String errorMethod() {
        return Thread.currentThread().getName() + "o(╥﹏╥)o!";
    }
}
