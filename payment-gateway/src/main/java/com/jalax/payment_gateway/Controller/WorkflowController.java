package com.jalax.payment_gateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.Task;
import com.jalax.payment_gateway.Entity.Workflow;
import com.jalax.payment_gateway.Service.WorkflowService;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {
	
    private final WorkflowService workflowService;

    @Autowired
    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping
    public ResponseEntity<Workflow> createWorkflow(@RequestBody Workflow workflow) {
        Workflow createdWorkflow = workflowService.createWorkflow(workflow);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorkflow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workflow> updateWorkflow(@PathVariable Long id, @RequestBody Workflow workflow) throws Exception {
        Workflow updatedWorkflow = workflowService.updateWorkflow(id, workflow);
        return ResponseEntity.ok(updatedWorkflow);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkflow(@PathVariable Long id) throws Exception {
        workflowService.deleteWorkflow(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Workflow>> getAllWorkflows() {
        List<Workflow> workflows = workflowService.getAllWorkflows();
        return ResponseEntity.ok(workflows);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Workflow>> getWorkflowsByStatus(@PathVariable String status) {
        List<Workflow> workflows = workflowService.getWorkflowsByStatus(status);
        return ResponseEntity.ok(workflows);
    }

    @PostMapping("/{workflowId}/tasks")
    public ResponseEntity<Task> createTask(@PathVariable Long workflowId, @RequestBody Task task) throws Exception {
        Task createdTask = workflowService.createTask(workflowId, task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) throws Exception {
        Task updatedTask = workflowService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) throws Exception {
        workflowService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{workflowId}/tasks")
    public ResponseEntity<List<Task>> getAllTasksByWorkflow(@PathVariable Long workflowId) {
        List<Task> tasks = workflowService.getAllTasksByWorkflow(workflowId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
        List<Task> tasks = workflowService.getTasksByStatus(status);
        return ResponseEntity.ok(tasks);
    }
}
