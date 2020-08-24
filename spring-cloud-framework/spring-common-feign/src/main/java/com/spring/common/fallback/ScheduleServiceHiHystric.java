package com.spring.common.fallback;

import com.spring.common.feign.ScheduleServiceHi;
import org.springframework.stereotype.Component;

/**
 * 熔断器 fallback
 * @author zhoucg
 * @date 2019-11-19 16:00
 */
@Component
public class ScheduleServiceHiHystric implements ScheduleServiceHi {

    @Override
    public String sayProvider(String name) {
        System.out.println("返回了错误信息");
        return "sorry "+name;
    }
}
