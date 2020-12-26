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

//        异常
//        int i = 10/0;
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

    @Override
    public String mehtodD(Integer integer) {
        if (integer < 0) {
            throw new RuntimeException("不能为负数！！");
        }
        return "调用成功，入参id:" + integer;
    }
}
