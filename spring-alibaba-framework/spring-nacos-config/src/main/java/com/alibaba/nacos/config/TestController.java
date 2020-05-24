package com.alibaba.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoucg
 * @date 2020-05-24 9:25
 */
@RestController
public class TestController {

    @Value("${author}")
    private String author;


    @GetMapping("/hello")
    public String hello() {
        return author;
    }
}
