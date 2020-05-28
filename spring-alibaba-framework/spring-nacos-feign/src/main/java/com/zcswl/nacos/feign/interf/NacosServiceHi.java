package com.zcswl.nacos.feign.interf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhoucg
 * @date 2020-05-23 12:34
 */
@FeignClient(value = "nacos-service-provider", fallback = TestFallback.class, configuration = FeignConfiguration.class)
public interface NacosServiceHi {


    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);
}

class TestFallback implements NacosServiceHi {


    public String echo(String str) {
        return "hello feign fallback";
    }
}

@Configuration
class FeignConfiguration {

    @Bean
    public TestFallback testFallback() {
        return new TestFallback();
    }
}
