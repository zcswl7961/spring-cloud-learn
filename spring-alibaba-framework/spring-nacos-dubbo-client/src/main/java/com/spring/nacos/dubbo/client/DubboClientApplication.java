package com.spring.nacos.dubbo.client;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhoucg
 * @date 2020-05-26 11:46
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class DubboClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(DubboClientApplication.class, args);
    }



}
