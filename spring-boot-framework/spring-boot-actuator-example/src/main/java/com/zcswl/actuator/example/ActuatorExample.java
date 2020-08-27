package com.zcswl.actuator.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * spring-boot actuator: {@link }https://blog.csdn.net/alinyua/article/details/80009435
 * 官方文档：
 * https://docs.spring.io/spring-boot/docs/2.2.9.RELEASE/reference/html/production-ready-features.html#production-ready
 *
 *
 * @author zhoucg
 * @date 2020-02-28 9:31
 */
@SpringBootApplication
public class ActuatorExample {


    public static void main(String[] args) {
        SpringApplication.run(ActuatorExample.class,args);
    }

    @Bean
    public HealthIndicator healthIndicator() {
        return () -> Health.down().withDetail("hello", "world").build();
    }
}
