package com.jalax.payment_gateway.Repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	
    List<Report> findByNameContainingIgnoreCase(String name);
    
    List<Report> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

}
