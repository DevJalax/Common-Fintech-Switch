package com.jalax.payment_gateway.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.LogEntry;
import com.jalax.payment_gateway.Repo.LogEntryRepository;

@Service
public class LogEntryService {
	
    private final LogEntryRepository logEntryRepository;

    @Autowired
    public LogEntryService(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    public LogEntry createLogEntry(LogEntry logEntry) {
        return logEntryRepository.save(logEntry);
    }

    public List<LogEntry> getLogEntriesByServiceName(String serviceName) {
        return logEntryRepository.findByServiceName(serviceName);
    }

    public List<LogEntry> getLogEntriesByLevel(String level) {
        return logEntryRepository.findByLevel(level);
    }

    public List<LogEntry> getLogEntriesByTimestampRange(String startTime, String endTime) {
        return logEntryRepository.findByTimestampBetween(startTime, endTime);
    }
}
