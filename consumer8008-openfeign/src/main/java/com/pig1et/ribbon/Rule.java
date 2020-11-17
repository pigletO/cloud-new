package com.pig1et.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 指定ribbon的轮询策略，注意此配置类一定不能放到@ComponentScan可以扫描到的包下
 * @author: pig1etO
 * @create: 2020-11-10 17:11
 **/
@Configuration
public class Rule {

    @Bean
    public IRule getRibbonRule() {
        System.out.println("11111111111111111111111111111111111111111");
//        return new RandomRule();
        return new CustomLoadBalanceRule();
    }
}
