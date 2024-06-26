package com.jalax.payment_gateway.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Trace;
import com.jalax.payment_gateway.Repo.TraceRepository;

@Service
public class TraceService {
	
    private final TraceRepository traceRepository;

    @Autowired
    public TraceService(TraceRepository traceRepository) {
        this.traceRepository = traceRepository;
    }

    public Trace createTrace(Trace trace) {
        return traceRepository.save(trace);
    }

    public List<Trace> getTracesByServiceNameAndOperationName(String serviceName, String operationName) {
        return traceRepository.findByServiceNameAndOperationName(serviceName, operationName);
    }

    public List<Trace> getTracesByServiceName(String serviceName) {
        return traceRepository.findByServiceName(serviceName);
    }

    public List<Trace> getTracesByTimeRange(Long startTime, Long endTime) {
        return traceRepository.findByStartTimeBetween(startTime, endTime);
    }
}
