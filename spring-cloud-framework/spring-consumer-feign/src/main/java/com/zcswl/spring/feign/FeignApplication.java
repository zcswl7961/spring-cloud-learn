package com.zcswl.spring.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 加上@EnableFeignClients注解开启Feign的功能：
 *
 * @SpringCloudApplication  注解使用
 *
 * @author zhoucg
 * @date 2019-11-19 15:43
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run( FeignApplication.class, args );
    }
}
