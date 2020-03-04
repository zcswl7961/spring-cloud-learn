package com.zcswl.spring.zuul.controller;

import com.zcswl.spring.zuul.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoucg
 * @date 2019-11-19 18:34
 */
@RestController
public class MyController {

    @Autowired
    private MyFilter myFilter;

    @RequestMapping("/test")
    public String test(){
        return "hello-world";
    }
}
