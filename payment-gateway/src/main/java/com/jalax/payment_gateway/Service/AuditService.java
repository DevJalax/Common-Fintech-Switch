package com.jalax.payment_gateway.Service;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Audit;
import com.jalax.payment_gateway.Repo.AuditRepository;

@Service
public class AuditService {
	
    private final AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void createAudit(String action, String entity, Long entityId, String username) {
        Audit audit = new Audit();
        audit.setAction(action);
        audit.setEntity(entity);
        audit.setEntityId(entityId);
        audit.setUsername(username);
        audit.setTimestamp(new Timestamp(System.currentTimeMillis()));
        auditRepository.save(audit);
    }

    public List<Audit> getAuditsByEntityAndEntityId(String entity, Long entityId) {
        return auditRepository.findByEntityAndEntityId(entity, entityId);
    }

    public List<Audit> getAuditsByUsername(String username) {
        return auditRepository.findByUsername(username);
    }

    public List<Audit> getAuditsByTimestampRange(Timestamp startTime, Timestamp endTime) {
        return auditRepository.findByTimestampBetween(startTime, endTime);
    }
}
