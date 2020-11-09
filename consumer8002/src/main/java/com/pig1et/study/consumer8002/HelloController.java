package com.pig1et.study.consumer8002;

import com.pig1et.study.commonapi.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/methodA")
    public Object methodA(String str) {

        return helloService.methodA(str);
    }

    @GetMapping("/methodB")
    public Object methodB(String str) {
        // 接收数据尽量不要用Object接，返回值是个String的时候，前三位是UTF8的标记，Object转换有错误
        return restTemplate.getForObject("http://producer/hello/say?comeFrom=consumer8002&str=" + str, String.class);
    }
}
