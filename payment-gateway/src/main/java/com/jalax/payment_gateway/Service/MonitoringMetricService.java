package com.jalax.payment_gateway.Service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.MonitoringMetric;
import com.jalax.payment_gateway.Repo.MonitoringMetricRepository;

@Service
public class MonitoringMetricService {
	
    private final MonitoringMetricRepository repository;

    @Autowired
    public MonitoringMetricService(MonitoringMetricRepository repository) {
        this.repository = repository;
    }

    public void saveMetric(MonitoringMetric metric) {
        repository.save(metric);
    }

    public List<MonitoringMetric> getMetricsByServiceAndNameAndTimeRange(
        String serviceName, String metricName, Instant startTime, Instant endTime) {
        return repository.findByServiceNameAndMetricNameAndTimestampBetween(
            serviceName, metricName, startTime, endTime);
    }
}
