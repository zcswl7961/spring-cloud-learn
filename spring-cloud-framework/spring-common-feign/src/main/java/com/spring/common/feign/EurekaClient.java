package com.spring.common.feign;

import com.spring.common.constant.CommonConstants;
import com.spring.common.fallback.EurekaClientHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhoucg
 * @date 2020-08-21 13:58
 */
@FeignClient(value = CommonConstants.EUREKA_CLIENT,
        fallback = EurekaClientHystric.class, path = "")
public interface EurekaClient {

    /**
     * hello demo feing
     * @return str
     */
    @RequestMapping(value = "/loadbalance",method = RequestMethod.GET)
    String hello();

}
