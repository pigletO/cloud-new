package com.pig1et.study.producer9001.controller;

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

    @GetMapping("say")
    public String MethodA(String str, String comeFrom) {
        log.info("【hello/say】comeFrom:{}", comeFrom);
        return helloService.methodA(str) + "invoke Server:" + port + ",come from Server:" + comeFrom;
    }
}
