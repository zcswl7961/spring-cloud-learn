package com.alibaba.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 通过refreshScope 实现动态的配置加载
 * @author zhoucg
 * @date 2020-05-24 9:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
