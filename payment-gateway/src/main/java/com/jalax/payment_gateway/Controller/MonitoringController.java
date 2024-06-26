package com.jalax.payment_gateway.Controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.MonitoringMetric;
import com.jalax.payment_gateway.Service.MonitoringMetricService;

@RestController
@RequestMapping("/api/monitoring")
public class MonitoringController {
	
    private final MonitoringMetricService service;

    @Autowired
    public MonitoringController(MonitoringMetricService service) {
        this.service = service;
    }

    @PostMapping("/metrics")
    public ResponseEntity<MonitoringMetric> createMetric(@RequestBody MonitoringMetric metric) {
        MonitoringMetric savedMetric = service.saveMetric(metric);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMetric);
    }

    @GetMapping("/metrics")
    public ResponseEntity<List<MonitoringMetric>> getMetrics(
        @RequestParam String serviceName,
        @RequestParam String metricName,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startTime,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endTime) {
        List<MonitoringMetric> metrics = service.getMetricsByServiceAndNameAndTimeRange(
            serviceName, metricName, startTime, endTime);
        return ResponseEntity.ok(metrics);
    }
}
