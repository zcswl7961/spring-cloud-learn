package com.zcswl.spring.feign.interf;

import org.springframework.stereotype.Component;

/**
 * 熔断器 fallback
 * @author zhoucg
 * @date 2019-11-19 16:00
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

    @Override
    public String sayProvider(String name) {
        System.out.println("返回了错误信息");
        return "sorry "+name;
    }
}
