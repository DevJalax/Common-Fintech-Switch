package com.jalax.payment_gateway.Repo;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.MonitoringMetric;

@Repository
public interface MonitoringMetricRepository extends JpaRepository<MonitoringMetric, Long> {
	
    List<MonitoringMetric> findByServiceNameAndMetricNameAndTimestampBetween(
        String serviceName, String metricName, Instant startTime, Instant endTime);

}
