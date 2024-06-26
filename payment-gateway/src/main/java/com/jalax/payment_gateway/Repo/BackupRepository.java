package com.jalax.payment_gateway.Repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Backup;

@Repository
public interface BackupRepository extends JpaRepository<Backup, Long> {
	
    List<Backup> findByStatus(String status);
    
    List<Backup> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

}
