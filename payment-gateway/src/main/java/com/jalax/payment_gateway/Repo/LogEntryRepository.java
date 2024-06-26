package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.LogEntry;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
	
    List<LogEntry> findByServiceName(String serviceName);

    List<LogEntry> findByLevel(String level);
    
    List<LogEntry> findByTimestampBetween(String startTime, String endTime);

}
