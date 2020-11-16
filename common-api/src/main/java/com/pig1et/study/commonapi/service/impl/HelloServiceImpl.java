package com.pig1et.study.commonapi.service.impl;

import com.pig1et.study.commonapi.service.HelloService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-06 15:58
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String methodA(String str) {
        return str;
    }

    @Override
    public String methodB(String str) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }
}
