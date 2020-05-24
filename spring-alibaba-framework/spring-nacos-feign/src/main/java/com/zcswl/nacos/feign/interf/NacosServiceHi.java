package com.zcswl.nacos.feign.interf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhoucg
 * @date 2020-05-23 12:34
 */
@FeignClient(value = "nacos-service-provider")
public interface NacosServiceHi {


    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);
}
