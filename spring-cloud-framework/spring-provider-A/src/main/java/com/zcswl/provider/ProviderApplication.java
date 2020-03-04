package com.zcswl.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * eureka-client注册类，通过{@link EnableEurekaClient} 将当前的服务注册到eureka集群中
 * <p>在这里，我们通过{@link RestController} 注册一个接口信息，并返回当前服务的端口信息
 *
 * <p>我们也可以通过@EnableDiscoveryClient（替换@EnableEurekaClient） 注解注册服务到注册中心中
 * @author zhoucg
 * @date 2019-11-19 14:59
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run( ProviderApplication.class, args );
    }


    @Value("${server.port}")
    private String port;


    @RequestMapping("/provider")
    public String test(@RequestParam(value = "name", defaultValue = "zcswl7961") String name) {
        return "this port is:" + port + " name is:"+name;
    }
}
