package com.zcswl.provider;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * eureka-client注册类，通过{@link EnableEurekaClient} 将当前的服务注册到eureka集群中
 * <p>在这里，我们通过{@link RestController} 注册一个接口信息，并返回当前服务的端口信息
 *
 * <p>我们也可以通过@EnableDiscoveryClient（替换@EnableEurekaClient） 注解注册服务到注册中心中
 *
 * EnableDiscoveryClient
 *
 *
 * @author zhoucg
 * @date 2019-11-19 14:59
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run( ProviderApplication.class, args );
    }


    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;


    @RequestMapping("/provider")
    public String test(@RequestParam(value = "name", defaultValue = "zcswl7961") String name) {

        List<String> services = discoveryClient.getServices();
        /**
         * test code
         */
        for (String serviceId : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);

            for (ServiceInstance serviceInstance : instances) {
                URI uri = serviceInstance.getUri();
            }
        }

        return "this port is:" + port + " name is:"+name;
    }
}
