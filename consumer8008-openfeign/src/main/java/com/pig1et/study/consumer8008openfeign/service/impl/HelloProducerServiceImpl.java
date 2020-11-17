package com.pig1et.study.consumer8008openfeign.service.impl;

import com.pig1et.study.consumer8008openfeign.service.HelloProducerService;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-16 18:25
 **/
@Component
public class HelloProducerServiceImpl implements HelloProducerService {

    @Override
    public String methodA(String str, String comeFrom) {
        return "o(╥﹏╥)o methodA失败了！";
    }

    @Override
    public String methodB(String str, String comeFrom) {
        return "o(╥﹏╥)o methodB失败了！";
    }
}
