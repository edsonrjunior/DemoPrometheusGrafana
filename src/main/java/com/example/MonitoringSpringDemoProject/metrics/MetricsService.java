package com.example.MonitoringSpringDemoProject.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {
    private final Counter postRequestsCounter;

    public MetricsService(MeterRegistry meterRegistry) {
        this.postRequestsCounter = Counter.builder("post_criar_alunos_counter")
                .description("Total number of successful POST requests")
                .register(meterRegistry);
    }

    public void incrementPostRequests() {
        postRequestsCounter.increment();
    }
}
