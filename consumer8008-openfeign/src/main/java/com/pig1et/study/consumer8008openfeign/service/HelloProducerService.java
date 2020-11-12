package com.pig1et.study.consumer8008openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-12 15:07
 **/
@Component
@FeignClient(value = "producer")
@RequestMapping("hello")
public interface HelloProducerService {

    @GetMapping("say")
    String methodA(String str, String comeFrom);

}
