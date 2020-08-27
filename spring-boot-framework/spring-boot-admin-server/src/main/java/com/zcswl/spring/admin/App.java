package com.zcswl.spring.admin;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * spring-boot admin
 *
 * spring boot admin服务，加入到eureka中
 *
 *
 * 官方的参考文档：
 * https://codecentric.github.io/spring-boot-admin/2.0.0/
 *
 * @author zhoucg
 * @date 2020-02-27 15:15
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class App {

    public static void main(String[] args) {
        SpringApplication.run( App.class, args );
    }
}
