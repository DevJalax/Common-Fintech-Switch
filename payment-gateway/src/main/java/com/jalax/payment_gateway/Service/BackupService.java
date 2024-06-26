package com.jalax.payment_gateway.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Backup;
import com.jalax.payment_gateway.Repo.BackupRepository;

@Service
public class BackupService {
	
    private final BackupRepository backupRepository;

    @Autowired
    public BackupService(BackupRepository backupRepository) {
        this.backupRepository = backupRepository;
    }

    public Backup createBackup(Backup backup) {
        backup.setCreatedAt(LocalDateTime.now());
        backup.setStatus("PENDING");
        return backupRepository.save(backup);
    }

    public List<Backup> getAllBackups() {
        return backupRepository.findAll();
    }

    public Backup getBackupById(Long id) throws Exception {
        return backupRepository.findById(id)
                .orElseThrow(() -> new Exception("Backup not found with id: " + id));
    }

    public List<Backup> getBackupsByStatus(String status) {
        return backupRepository.findByStatus(status);
    }

    public List<Backup> getBackupsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return backupRepository.findByCreatedAtBetween(startDate, endDate);
    }

    public Backup updateBackup(Long id, Backup updatedBackup) throws Exception {
        Backup backup = getBackupById(id);
        backup.setName(updatedBackup.getName());
        backup.setBackupTime(updatedBackup.getBackupTime());
        backup.setStatus(updatedBackup.getStatus());
        return backupRepository.save(backup);
    }

    public void deleteBackup(Long id) throws Exception {
        Backup backup = getBackupById(id);
        backupRepository.delete(backup);
    }
}
