package com.zcswl.spring.zipkin;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 通过zipkin监控链路调用过程
 *
 * @author zhoucg
 * @date 2019-11-20 13:20
 */
@SpringBootApplication
@RestController
@EnableFeignClients
public class ZipkinServerApplication {

    private static final Logger LOG = Logger.getLogger(ZipkinServerApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class,args);
    }


    /**
     * 基于restTemplate 方式进行服务调用 测试zipkin
     */
    @Autowired
    private RestTemplate restTemplate;


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
        LOG.log(Level.INFO, "calling trace zipkin-hi  ");
        return restTemplate.getForObject("http://localhost:8769/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        LOG.log(Level.INFO, "calling trace zipkin-hi ");
        return "i'm zipkin-hi";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
