package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Trace;

@Repository
public interface TraceRepository extends JpaRepository<Trace, Long> {
	
    List<Trace> findByServiceNameAndOperationName(String serviceName, String operationName);
    
    List<Trace> findByServiceName(String serviceName);
    
    List<Trace> findByStartTimeBetween(Long startTime, Long endTime);
}
