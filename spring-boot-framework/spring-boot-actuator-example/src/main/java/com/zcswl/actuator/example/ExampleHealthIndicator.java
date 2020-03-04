package com.zcswl.actuator.example;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author zhoucg
 * @date 2020-02-28 9:47
 */
@Component
public class ExampleHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("counter",42).build();
    }
}
