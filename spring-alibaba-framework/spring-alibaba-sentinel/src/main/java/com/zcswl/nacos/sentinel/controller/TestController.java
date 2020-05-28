package com.zcswl.nacos.sentinel.controller;

import com.zcswl.nacos.sentinel.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoucg
 * @date 2020-05-28 14:22
 */
@RestController
@AllArgsConstructor
public class TestController {

    private final TestService testService;
    
    @GetMapping("/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return testService.sayHello(name);
    }
}
