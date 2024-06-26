package com.jalax.payment_gateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.LogEntry;
import com.jalax.payment_gateway.Service.LogEntryService;

@RestController
@RequestMapping("/api/logs")
public class LogEntryController {
	
    private final LogEntryService logEntryService;

    @Autowired
    public LogEntryController(LogEntryService logEntryService) {
        this.logEntryService = logEntryService;
    }

    @PostMapping
    public ResponseEntity<LogEntry> createLogEntry(@RequestBody LogEntry logEntry) {
        LogEntry createdLogEntry = logEntryService.createLogEntry(logEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLogEntry);
    }

    @GetMapping("/service/{serviceName}")
    public ResponseEntity<List<LogEntry>> getLogEntriesByServiceName(@PathVariable String serviceName) {
        List<LogEntry> logEntries = logEntryService.getLogEntriesByServiceName(serviceName);
        return ResponseEntity.ok(logEntries);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<LogEntry>> getLogEntriesByLevel(@PathVariable String level) {
        List<LogEntry> logEntries = logEntryService.getLogEntriesByLevel(level);
        return ResponseEntity.ok(logEntries);
    }

    @GetMapping("/timestamp")
    public ResponseEntity<List<LogEntry>> getLogEntriesByTimestampRange(
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime) {
        List<LogEntry> logEntries = logEntryService.getLogEntriesByTimestampRange(startTime, endTime);
        return ResponseEntity.ok(logEntries);
    }
}
