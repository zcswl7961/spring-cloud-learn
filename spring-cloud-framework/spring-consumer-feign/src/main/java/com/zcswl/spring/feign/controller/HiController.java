package com.zcswl.spring.feign.controller;

import com.spring.common.feign.EurekaClient;
import com.spring.common.feign.ScheduleServiceHi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhoucg
 * @date 2019-11-19 15:46
 */
@RestController
@AllArgsConstructor
public class HiController {

    private final ScheduleServiceHi scheduleServiceHi;

    private final EurekaClient eurekaClient;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return scheduleServiceHi.sayProvider( name );
    }


    @GetMapping("/client")
    public String getEurekaClient() {
        return eurekaClient.hello();
    }


    /**
     * Local test connection
     */
    public static void main(String[] args) throws IOException {

    }
}
