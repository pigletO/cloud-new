package com.pig1et.study.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: GateWay网关配置的第二种方式
 * @author: pig1etO
 * @create: 2020-11-19 17:50
 **/
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("route_id", predicateSpec -> predicateSpec.path("/A").uri("http://localhost:9008/hello/say"))
                .route("route_id2", predicateSpec -> predicateSpec.path("/B").uri("http://localhost:9008/hello/timeout"));
        return routes.build();
    }
}
