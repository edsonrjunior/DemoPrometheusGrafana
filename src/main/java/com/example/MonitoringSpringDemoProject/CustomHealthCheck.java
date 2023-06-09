package com.example.MonitoringSpringDemoProject;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;


@Component
public class CustomHealthCheck extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean running = true;
        if (running) {
            builder.up();
        } else {
            builder.down();
        }
    }
}
