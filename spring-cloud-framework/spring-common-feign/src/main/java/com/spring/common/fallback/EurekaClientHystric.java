package com.spring.common.fallback;

import com.spring.common.feign.EurekaClient;
import org.springframework.stereotype.Component;

/**
 * @author zhoucg
 * @date 2020-08-21 14:11
 */
@Component
public class EurekaClientHystric implements EurekaClient {
    @Override
    public String hello() {
        return "错误回调";
    }
}
