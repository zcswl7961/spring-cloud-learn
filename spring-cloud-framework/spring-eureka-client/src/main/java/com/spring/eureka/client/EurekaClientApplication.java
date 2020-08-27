package com.spring.eureka.client;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 啊  这个乱码？？？？？？？？？？
 * @author zhoucg
 * @date 2020-08-03 18:03
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApplication {


    @Autowired
    private EurekaClient eurekaClient;


    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }


    @GetMapping("/loadbalance")
    public String test() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service-gateway", false);
        System.out.println(instanceInfo);
        return "中文乱码处理";

    }

    @GetMapping("/test")
    public String test1() {
        System.out.println("乱码？？？？？？？？？");
        return "这个会乱码";
    }

}

