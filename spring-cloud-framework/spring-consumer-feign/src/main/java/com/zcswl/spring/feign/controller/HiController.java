package com.zcswl.spring.feign.controller;

import com.zcswl.spring.feign.interf.ScheduleServiceHi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoucg
 * @date 2019-11-19 15:46
 */
@RestController
@AllArgsConstructor
public class HiController {

    /**
     * 编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
     */
    private final ScheduleServiceHi scheduleServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return scheduleServiceHi.sayProvider( name );
    }
}
