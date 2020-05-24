package com.zcswl.nacos.feign;

import com.zcswl.nacos.feign.interf.NacosServiceHi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoucg
 * @date 2020-05-23 12:36
 */
@RestController
@AllArgsConstructor
public class ControllerHello {


    private final NacosServiceHi nacosServiceHi;


    @GetMapping("/feign/{str}")
    public String feign(@PathVariable String str) {
        String echo = nacosServiceHi.echo(str);

        System.out.println(echo);
        return echo;
    }
}
