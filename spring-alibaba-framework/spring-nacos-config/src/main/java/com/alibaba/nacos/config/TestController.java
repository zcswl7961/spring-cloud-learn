package com.alibaba.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope 需要具体到对应的需要热加载的类上
 * @author zhoucg
 * @date 2020-05-24 9:25
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${author}")
    private String author;

    @Value("${zcg.home}")
    private String home;


    @GetMapping("/hello")
    public String hello() {
        return author + home;
    }
}
