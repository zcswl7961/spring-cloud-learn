package com.alibaba.nacos.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos服务注册信息接口
 *
 * @author zhoucg
 * @date 2020-05-23 12:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }


    /**
     * 作为服务提供者
     */
    @RestController
    class EchoController {

        /**
         * 服务接口1
         */
        @GetMapping("/echo/{str}")
        public String echo(@PathVariable String str) {
            return str+":ZHOUCG";
        }

    }
}
