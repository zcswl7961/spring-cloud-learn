package com.zcswl.spring.feign.controller;

import com.spring.common.feign.SpringEurekaClientFeign;
import com.spring.common.feign.SpringProviderAFeign;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 作为Feigin的客户端（也就是接口的提供者）
 * 同样需要注册到Eureka和zipkin中
 * @author zhoucg
 * @date 2019-11-19 15:46
 */
@RestController
@AllArgsConstructor
public class HiController {

    private final SpringProviderAFeign springProviderAFeign;

    private final SpringEurekaClientFeign springEurekaClientFeign;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return springProviderAFeign.sayProvider( name );
    }


    @GetMapping("/client")
    public String getSpringEurekaClientFeign() {
        return springEurekaClientFeign.hello();
    }


    /**
     * Local test connection
     */
    public static void main(String[] args) throws IOException {

    }
}
