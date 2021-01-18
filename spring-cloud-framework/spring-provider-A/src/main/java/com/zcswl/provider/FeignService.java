package com.zcswl.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhoucg
 * @date 2020-06-04 17:00
 */
@FeignClient(value = "spring-consumer-feign")
public interface FeignService {


    /**
     * 接口调用
     * @param name 名称
     * @return 返回结果
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayProvider(@RequestParam("name") String name);


}
