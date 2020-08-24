package com.zcswl.spring.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka注册中心启动类
 *
 * spring cloud Eureka注册中心集群如何实现客户端请求负载及故障转移
 *
 *
 * EurekaServer集群内部信息如何同步？
 *
 *
 *
 *
 * @author zhoucg
 * @date 2019-11-19 14:36
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run( EurekaApplication.class, args );
    }
}
