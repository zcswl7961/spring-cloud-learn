package com.spring.nacos.dubbo.server;

import com.spring.nacos.dubbo.support.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zhoucg
 * @date 2020-05-26 11:09
 */
@Service(group = "provider", version = "${demo.service.version}")
public class HelloServiceImpl implements HelloService {

    public String sayHello(String name) {
        return "zhoucgWL : " + name;
    }
}
