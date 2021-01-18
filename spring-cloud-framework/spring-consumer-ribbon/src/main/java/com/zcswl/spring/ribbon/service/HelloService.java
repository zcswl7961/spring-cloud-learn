package com.zcswl.spring.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhoucg
 * @date 2019-11-19 15:31
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * spring-provider-A注册进去的服务数据
     *
     * 在hiService方法上加上@HystrixCommand注解。该注解对该方法创建了熔断器的功能
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod  = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SPRING-PROVIDER-A/provider?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
