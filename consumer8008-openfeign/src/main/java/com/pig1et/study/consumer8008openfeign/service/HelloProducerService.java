package com.pig1et.study.consumer8008openfeign.service;

import com.pig1et.study.consumer8008openfeign.service.impl.HelloProducerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-12 15:07
 **/
@Component
/**
 * 指定了fallback参数后，一旦发生运行时异常，超时异常，或宕机情况时，自动调用相对应的降级代码
 * 需要开启Hystrix支持
 */
@FeignClient(value = "producer", fallback = HelloProducerServiceImpl.class)
//@RequestMapping("hello")
public interface HelloProducerService {

    @GetMapping("hello/say")
    String methodA(@RequestParam String str, @RequestParam String comeFrom);

    @GetMapping("hello/timeout")
    String methodB(@RequestParam String str, @RequestParam String comeFrom);

    @GetMapping("hello/circuitBreaker")
    String methodD(@RequestParam Integer integer, @RequestParam String comeFrom);

}
