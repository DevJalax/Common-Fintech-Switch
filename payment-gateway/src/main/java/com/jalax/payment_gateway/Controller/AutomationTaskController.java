package com.jalax.payment_gateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.AutomationTask;
import com.jalax.payment_gateway.Service.AutomationTaskService;

@RestController
@RequestMapping("/api/automation-tasks")
public class AutomationTaskController {
	
    private final AutomationTaskService automationTaskService;

    @Autowired
    public AutomationTaskController(AutomationTaskService automationTaskService) {
        this.automationTaskService = automationTaskService;
    }

    @GetMapping
    public List<AutomationTask> getAllActiveTasks() {
        return automationTaskService.getAllActiveTasks();
    }

    @PostMapping
    public AutomationTask createTask(@RequestBody AutomationTask task) {
        return automationTaskService.createTask(task);
    }

    @PutMapping("/{id}")
    public AutomationTask updateTask(@PathVariable Long id, @RequestBody AutomationTask task) throws Exception {
        return automationTaskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) throws Exception {
        automationTaskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
