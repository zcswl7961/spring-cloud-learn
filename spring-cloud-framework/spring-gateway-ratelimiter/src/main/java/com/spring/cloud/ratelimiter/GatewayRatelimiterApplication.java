package com.spring.cloud.ratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhoucg
 * @date 2019-11-22 17:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayRatelimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayRatelimiterApplication.class,args);
    }
}
