package com.jalax.payment_gateway.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.Backup;
import com.jalax.payment_gateway.Service.BackupService;

@RestController
@RequestMapping("/api/backups")
public class BackupController {
	
    private final BackupService backupService;

    @Autowired
    public BackupController(BackupService backupService) {
        this.backupService = backupService;
    }

    @PostMapping
    public ResponseEntity<Backup> createBackup(@RequestBody Backup backup) {
        Backup createdBackup = backupService.createBackup(backup);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBackup);
    }

    @GetMapping
    public ResponseEntity<List<Backup>> getAllBackups() {
        List<Backup> backups = backupService.getAllBackups();
        return ResponseEntity.ok(backups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Backup> getBackupById(@PathVariable Long id) throws Exception {
        Backup backup = backupService.getBackupById(id);
        return ResponseEntity.ok(backup);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Backup>> getBackupsByStatus(@PathVariable String status) {
        List<Backup> backups = backupService.getBackupsByStatus(status);
        return ResponseEntity.ok(backups);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Backup>> getBackupsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<Backup> backups = backupService.getBackupsByDateRange(startDate, endDate);
        return ResponseEntity.ok(backups);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Backup> updateBackup(@PathVariable Long id, @RequestBody Backup backup) throws Exception {
        Backup updatedBackup = backupService.updateBackup(id, backup);
        return ResponseEntity.ok(updatedBackup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBackup(@PathVariable Long id) throws Exception {
        backupService.deleteBackup(id);
        return ResponseEntity.noContent().build();
    }
}
