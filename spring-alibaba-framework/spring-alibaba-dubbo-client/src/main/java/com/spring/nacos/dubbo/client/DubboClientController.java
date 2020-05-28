package com.spring.nacos.dubbo.client;

import com.spring.nacos.dubbo.support.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoucg
 * @date 2020-05-26 11:49
 */
@RestController
public class DubboClientController {


    @Reference(group = "provider")
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        String str = helloService.sayHello("zhoucg");
        return str;
    }
}
