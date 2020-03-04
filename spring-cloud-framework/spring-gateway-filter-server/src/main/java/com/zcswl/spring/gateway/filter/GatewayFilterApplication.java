package com.zcswl.spring.gateway.filter;

import com.zcswl.spring.gateway.filter.filter.RequestTimeFilter;
import com.zcswl.spring.gateway.filter.filter.RequestTimeGatewayFilterFactory;
import com.zcswl.spring.gateway.filter.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring cloud gateway filter
 * @author zhoucg
 * @date 2019-11-22 16:48
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GatewayFilterApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class,args);
    }

    /*@Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/customer*//**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
    }*/


    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
