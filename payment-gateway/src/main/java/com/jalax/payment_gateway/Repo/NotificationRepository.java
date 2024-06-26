package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.DTO.NotificationStatus;
import com.jalax.payment_gateway.Entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
    List<Notification> findByUserId(Long userId);
    
    List<Notification> findByStatus(NotificationStatus status);

}
