package com.zcswl.spring.zipkin.controller;

import com.zcswl.spring.zipkin.interf.FeignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 通过feign client的方式进行服务调度
 *
 * zipkin-service(spring-zipkin-server-sample) --> service-feign(spring-consumer-feign) --> service-hi(spring-provider-A)
 *
 * 来检测对应的链路追踪
 *
 *
 * @author zhoucg
 * @date 2020-06-04 16:59
 */
@RestController
@AllArgsConstructor
public class SampleController {


    private final FeignService feignService;


    @GetMapping("/hi/{name}")
    public String sayHi(@PathVariable String name) {

        String s = feignService.sayProvider(name);

        return s;

    }
}
