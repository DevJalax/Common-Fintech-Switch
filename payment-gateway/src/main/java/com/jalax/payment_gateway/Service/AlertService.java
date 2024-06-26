package com.jalax.payment_gateway.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.DTO.AlertStatus;
import com.jalax.payment_gateway.DTO.AlertType;
import com.jalax.payment_gateway.Entity.Alert;
import com.jalax.payment_gateway.Repo.AlertRepository;

@Service
public class AlertService {
    private final AlertRepository alertRepository;

    @Autowired
    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public Alert createAlert(String title, String message, AlertType type) {
        Alert alert = new Alert();
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setType(type);
        alert.setStatus(AlertStatus.OPEN);
        alert.setCreatedAt(LocalDateTime.now());
        return alertRepository.save(alert);
    }

    public void resolveAlert(Long id) throws Exception {
        Alert alert = alertRepository.findById(id)
                .orElseThrow(() -> new Exception("Alert not found"));
        alert.setStatus(AlertStatus.RESOLVED);
        alert.setResolvedAt(LocalDateTime.now());
        alertRepository.save(alert);
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public List<Alert> getAlertsByStatus(AlertStatus status) {
        return alertRepository.findByStatus(status);
    }

    public List<Alert> getAlertsByType(AlertType type) {
        return alertRepository.findByType(type);
    }

    public List<Alert> getAlertsByStatusAndType(AlertStatus status, AlertType type) {
        return alertRepository.findByStatusAndType(status, type);
    }
}
