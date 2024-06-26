package com.jalax.payment_gateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.DTO.NotificationStatus;
import com.jalax.payment_gateway.Entity.Notification;
import com.jalax.payment_gateway.Service.NotificationService;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
	
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNotification);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Long userId) {
        List<Notification> userNotifications = notificationService.getUserNotifications(userId);
        return ResponseEntity.ok(userNotifications);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Notification>> getPendingNotifications() {
        List<Notification> pendingNotifications = notificationService.getPendingNotifications();
        return ResponseEntity.ok(pendingNotifications);
    }

    @PutMapping("/{notificationId}/status")
    public ResponseEntity<Notification> updateNotificationStatus(
            @PathVariable Long notificationId,
            @RequestParam NotificationStatus status) throws Exception {
        Notification updatedNotification = notificationService.updateNotificationStatus(notificationId, status);
        return ResponseEntity.ok(updatedNotification);
    }
}
