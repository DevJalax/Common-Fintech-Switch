package com.jalax.payment_gateway.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Task;
import com.jalax.payment_gateway.Entity.Workflow;
import com.jalax.payment_gateway.Repo.TaskRepository;
import com.jalax.payment_gateway.Repo.WorkflowRepository;

@Service
public class WorkflowService {
	
    private final WorkflowRepository workflowRepository;
    
    private final TaskRepository taskRepository;

    public WorkflowService(WorkflowRepository workflowRepository, TaskRepository taskRepository) {
        this.workflowRepository = workflowRepository;
        this.taskRepository = taskRepository;
    }

    public Workflow createWorkflow(Workflow workflow) {
        workflow.setCreatedAt(LocalDateTime.now());
        workflow.setUpdatedAt(LocalDateTime.now());
        return workflowRepository.save(workflow);
    }

    public Workflow updateWorkflow(Long id, Workflow workflow) throws Exception {
        Workflow existingWorkflow = workflowRepository.findById(id)
                .orElseThrow(() -> new Exception("Workflow not found with id: " + id));
        existingWorkflow.setName(workflow.getName());
        existingWorkflow.setDescription(workflow.getDescription());
        existingWorkflow.setStatus(workflow.getStatus());
        existingWorkflow.setUpdatedAt(LocalDateTime.now());
        return workflowRepository.save(existingWorkflow);
    }

    public void deleteWorkflow(Long id) throws Exception {
        Workflow workflow = workflowRepository.findById(id)
                .orElseThrow(() -> new Exception("Workflow not found with id: " + id));
        workflowRepository.delete(workflow);
    }

    public List<Workflow> getAllWorkflows() {
        return workflowRepository.findAll();
    }

    public List<Workflow> getWorkflowsByStatus(String status) {
        return workflowRepository.findByStatus(status);
    }

    public Task createTask(Long workflowId, Task task) throws Exception {
        Workflow workflow = workflowRepository.findById(workflowId)
                .orElseThrow(() -> new Exception("Workflow not found with id: " + workflowId));
        task.setWorkflow(workflow);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) throws Exception {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task not found with id: " + id));
        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) throws Exception {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task not found with id: " + id));
        taskRepository.delete(task);
    }

    public List<Task> getAllTasksByWorkflow(Long workflowId) {
        return taskRepository.findByWorkflowId(workflowId);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
