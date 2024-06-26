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
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.DTO.AlertStatus;
import com.jalax.payment_gateway.DTO.AlertType;
import com.jalax.payment_gateway.Entity.Alert;
import com.jalax.payment_gateway.Service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
	
    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody AlertRequest alertRequest) {
        Alert alert = alertService.createAlert(
                alertRequest.getTitle(),
                alertRequest.getMessage(),
                AlertType.valueOf(alertRequest.getType().toUpperCase())
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(alert);
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<Void> resolveAlert(@PathVariable Long id) throws Exception {
        alertService.resolveAlert(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Alert>> getAllAlerts() {
        List<Alert> alerts = alertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Alert>> getAlertsByStatus(@PathVariable AlertStatus status) {
        List<Alert> alerts = alertService.getAlertsByStatus(status);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Alert>> getAlertsByType(@PathVariable AlertType type) {
        List<Alert> alerts = alertService.getAlertsByType(type);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/status/{status}/type/{type}")
    public ResponseEntity<List<Alert>> getAlertsByStatusAndType(
            @PathVariable AlertStatus status,
            @PathVariable AlertType type
    ) {
        List<Alert> alerts = alertService.getAlertsByStatusAndType(status, type);
        return ResponseEntity.ok(alerts);
    }
}
