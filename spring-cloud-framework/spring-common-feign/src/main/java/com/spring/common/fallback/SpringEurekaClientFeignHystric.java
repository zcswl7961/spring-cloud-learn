package com.spring.common.fallback;

import com.spring.common.feign.SpringEurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * @author zhoucg
 * @date 2020-08-21 14:11
 */
@Component
public class SpringEurekaClientFeignHystric implements SpringEurekaClientFeign {
    @Override
    public String hello() {
        System.out.println("返回了错误信息， 这个怎么乱码");
        return "错误回调";
    }
}
