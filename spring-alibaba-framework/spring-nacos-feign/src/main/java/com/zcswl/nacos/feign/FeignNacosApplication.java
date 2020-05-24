package com.zcswl.nacos.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * alibaba nacos+feign 作为服务接口使用
 *
 * @author zhoucg
 * @date 2020-05-23 12:33
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run( FeignNacosApplication.class, args );
    }
}
