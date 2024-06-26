package com.jalax.payment_gateway.Repo;

import java.security.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
	
    List<Audit> findByEntityAndEntityId(String entity, Long entityId);
    
    List<Audit> findByUsername(String username);
    
    List<Audit> findByTimestampBetween(Timestamp startTime, Timestamp endTime);

}
