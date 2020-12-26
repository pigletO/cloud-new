package com.pig1et.study.consumer8010.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-12-18 13:28
 **/
@Slf4j
@RestController
@RequestMapping("/helloNacos")
@RefreshScope
public class HelloNacosController {

    @Value("${server.port:#{null}}")
    private String port;

    @Value("${config.value1}:#{'default'}")
    private String configValue;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/methodA")
    public String methodA() {
        log.info("");
        return "port:" + port + ",configValue:" + configValue;
    }

    @GetMapping("/methodB")
    public Object methodB(String str) {
        return restTemplate.getForObject("http://producer/hello/say?str=" + str + "&comeFrom=" + port, String.class);
    }

}
