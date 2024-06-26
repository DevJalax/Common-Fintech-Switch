package com.jalax.payment_gateway.Controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
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

import com.jalax.payment_gateway.Entity.Trace;
import com.jalax.payment_gateway.Service.TraceService;

@RestController
@RequestMapping("/traces")
public class TraceController {
	
    private final TraceService traceService;

    @Autowired
    public TraceController(TraceService traceService) {
        this.traceService = traceService;
    }

    @PostMapping
    public ResponseEntity<Trace> createTrace(@RequestBody Trace trace) {
        Trace savedTrace = traceService.createTrace(trace);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrace);
    }

    @GetMapping
    public ResponseEntity<List<Trace>> getTraces(
            @RequestParam(required = false) String serviceName,
            @RequestParam(required = false) String operationName,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        List<Trace> traces;
        if (serviceName != null && operationName != null) {
            traces = traceService.getTracesByServiceNameAndOperationName(serviceName, operationName);
        } else if (serviceName != null) {
            traces = traceService.getTracesByServiceName(serviceName);
        } else if (startTime != null && endTime != null) {
            traces = traceService.getTracesByTimeRange(startTime.toEpochSecond(ZoneOffset.UTC), endTime.toEpochSecond(ZoneOffset.UTC));
        } else {
            // Handle other cases or return an error
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(traces);
    }
}
