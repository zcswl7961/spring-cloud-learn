package com.zcswl.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * find dynamic spring cloud gateway route from nacos config
 * @author xingyi
 * @date ${DATE}
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}