package com.pig1et.study.producer9010sentinel.controller;

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

//    @Autowired
//    private HelloService helloService;

    @GetMapping("testMethod")
    public String testMethod(String str) {
        return port + "：" + str;
    }

//    @HystrixCommand(fallbackMethod = "errorMethod")
//    @GetMapping("say")
//    public String MethodA(String str, String comeFrom) {
//        log.info("【hello/say】comeFrom:{}", comeFrom);
//        return helloService.methodA(str) + "invoke Server:" + port + ",come from Server:" + comeFrom;
//    }
//
//    @GetMapping("timeout")
//    public String methodB(String str, String comeFrom) {
//        return helloService.methodB(str) + "invoke Server:" + port + ",come from Server:" + comeFrom;
//    }
//
//    /**
//     * 学习Hystrix熔断机制
//     * 熔断过程
//     * 1、请求数量超过阈值
//     * 2、然后错误百分比超过阈值
//     * 3、此时触发熔断，熔断开关Open
//     * 4、一段时间内所有请求都降级
//     * 5、在之后尝试放过一些请求，此时熔断开关Half-Open半开启状态
//     * 6、失败继续OPen，成功则Close，周而复始
//     * 7、Close
//     * @param integer
//     * @param comeFrom
//     * @return
//     */
//    @GetMapping("circuitBreaker")
//    public String methodD(Integer integer, String comeFrom) {
//        return helloService.mehtodD(integer);
//    }

    public String errorMethod(String str, String comeFrom) {
        return Thread.currentThread().getName() + "o(╥﹏╥)o:" + port;
    }

    public String methodDFallback(Integer integer, String comeFrom) {
        return "methodD调用失败 o(╥﹏╥)o~ id:" + integer + ",comeFrom:" + comeFrom;
    }
}
