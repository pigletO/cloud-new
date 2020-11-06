package com.pig1et.study.consumer8001.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-06 15:54
 **/
@Configuration
public class RestTemplateConfig {

    /**
     * 使用RestTemplate调用注册中心客户端接口时，必须开启负载均衡，否则不经过注册中心
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
