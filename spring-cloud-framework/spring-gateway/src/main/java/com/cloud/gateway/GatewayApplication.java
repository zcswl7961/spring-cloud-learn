package com.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring-Cloud-Gateway 网关服务
 *
 * @author zhoucg
 * @date 2020-06-04 14:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
