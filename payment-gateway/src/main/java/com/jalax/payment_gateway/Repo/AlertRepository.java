package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.DTO.AlertStatus;
import com.jalax.payment_gateway.DTO.AlertType;
import com.jalax.payment_gateway.Entity.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
	
    
	List<Alert> findByStatus(AlertStatus status);
    
	List<Alert> findByType(AlertType type);
    
	List<Alert> findByStatusAndType(AlertStatus status, AlertType type);
}
