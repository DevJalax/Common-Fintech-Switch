package com.jalax.payment_gateway.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.DTO.NotificationStatus;
import com.jalax.payment_gateway.Entity.Notification;
import com.jalax.payment_gateway.Repo.NotificationRepository;

@Service
public class NotificationService {
	
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(Notification notification) {
        notification.setCreatedAt(LocalDateTime.now());
        notification.setUpdatedAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public List<Notification> getPendingNotifications() {
        return notificationRepository.findByStatus(NotificationStatus.PENDING);
    }

    public Notification updateNotificationStatus(Long notificationId, NotificationStatus status) throws Exception {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new Exception("Notification not found"));
        notification.setStatus(status);
        notification.setUpdatedAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }
}
