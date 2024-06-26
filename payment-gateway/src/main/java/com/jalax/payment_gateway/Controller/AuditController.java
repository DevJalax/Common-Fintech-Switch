package com.jalax.payment_gateway.Controller;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.Audit;
import com.jalax.payment_gateway.Service.AuditService;

@RestController
@RequestMapping("/audits")
public class AuditController {
	
    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping
    public ResponseEntity<Void> createAudit(@RequestBody AuditRequest auditRequest) {
        auditService.createAudit(
            auditRequest.getAction(),
            auditRequest.getEntity(),
            auditRequest.getEntityId(),
            auditRequest.getUsername()
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/entity/{entity}/id/{entityId}")
    public ResponseEntity<List<Audit>> getAuditsByEntityAndEntityId(
        @PathVariable String entity,
        @PathVariable Long entityId
    ) {
        List<Audit> audits = auditService.getAuditsByEntityAndEntityId(entity, entityId);
        return ResponseEntity.ok(audits);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Audit>> getAuditsByUsername(@PathVariable String username) {
        List<Audit> audits = auditService.getAuditsByUsername(username);
        return ResponseEntity.ok(audits);
    }

    @GetMapping("/timestamp")
    public ResponseEntity<List<Audit>> getAuditsByTimestampRange(
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp startTime,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp endTime
    ) {
        List<Audit> audits = auditService.getAuditsByTimestampRange(startTime, endTime);
        return ResponseEntity.ok(audits);
    }
}
