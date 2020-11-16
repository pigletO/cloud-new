package com.pig1et.study.consumer8008openfeign.controller;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.pig1et.study.commonapi.service.HelloService;
import com.pig1et.study.consumer8008openfeign.service.HelloProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public String methodA(String str) {

        return helloProducerService.methodA(str, port);
    }

    @GetMapping("/methodB")
    public String methodB(String str) {

        return helloProducerService.methodB(str, port);
    }



}
