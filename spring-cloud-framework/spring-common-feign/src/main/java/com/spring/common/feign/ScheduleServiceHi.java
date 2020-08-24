package com.spring.common.feign;

import com.spring.common.constant.CommonConstants;
import com.spring.common.fallback.ScheduleServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhoucg
 * @date 2019-11-19 15:45
 */
@FeignClient(value = CommonConstants.SERVER_HI,fallback = ScheduleServiceHiHystric.class)
public interface ScheduleServiceHi {

    /**
     * 接口调用
     * @param name 名称
     * @return 返回结果
     */
    @RequestMapping(value = "/provider",method = RequestMethod.GET)
    String sayProvider(@RequestParam("name") String name);

}
