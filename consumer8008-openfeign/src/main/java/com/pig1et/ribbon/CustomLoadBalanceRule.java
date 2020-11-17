package com.pig1et.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 自定义ribbon轮询策略，需要实现AbstractLoadBalancerRule
 * @author: pig1etO
 * @create: 2020-11-11 13:50
 **/
public class CustomLoadBalanceRule extends AbstractLoadBalancerRule {

    private AtomicInteger current = new AtomicInteger(-1);
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        // 获取有效的服务器列表
        List<Server> upList = lb.getReachableServers();
        // 获取全部服务器列表
        List<Server> allList = lb.getAllServers();


        Server server = null;
        for (int i = 0; i++ < 10;) {
            int index = current.get();

            if (index == -1) {
                for (; ; ) {
                    if (current.compareAndSet(-1, 0)) {
                        break;
                    }
                }
            }
            index = current.get();
            server = allList.get(index);

            if (server == null) {
                // 自旋锁的实现， 每次都重新获取锁的新值，并尝试加锁，锁没获取到就再次获取新值
                for (; ; ) {
                    index = current.get();
                    int next = (index + 1) % allList.size();
                    if (current.compareAndSet(index, next)) {
                        break;
                    }
                }
                continue;
            }


        }
        return server;
    }
}
