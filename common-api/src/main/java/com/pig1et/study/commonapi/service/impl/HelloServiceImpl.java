package com.pig1et.study.commonapi.service.impl;

import com.pig1et.study.commonapi.service.HelloService;
import org.springframework.stereotype.Service;

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
}
