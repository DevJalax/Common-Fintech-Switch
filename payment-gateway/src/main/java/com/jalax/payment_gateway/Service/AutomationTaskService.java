package com.jalax.payment_gateway.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.AutomationTask;
import com.jalax.payment_gateway.Repo.AutomationTaskRepository;

@Service
public class AutomationTaskService {
	
    private final AutomationTaskRepository automationTaskRepository;

    @Autowired
    public AutomationTaskService(AutomationTaskRepository automationTaskRepository) {
        this.automationTaskRepository = automationTaskRepository;
    }

    public List<AutomationTask> getAllActiveTasks() {
        return automationTaskRepository.findByActiveTrue();
    }

    public AutomationTask createTask(AutomationTask task) {
        return automationTaskRepository.save(task);
    }

    public AutomationTask updateTask(Long id, AutomationTask updatedTask) throws Exception {
        AutomationTask task = automationTaskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task not found with id: " + id));

        task.setName(updatedTask.getName());
        task.setDescription(updatedTask.getDescription());
        task.setTrigger(updatedTask.getTrigger());
        task.setAction(updatedTask.getAction());
        task.setActive(updatedTask.isActive());

        return automationTaskRepository.save(task);
    }

    public void deleteTask(Long id) throws Exception {
        AutomationTask task = automationTaskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task not found with id: " + id));

        automationTaskRepository.delete(task);
    }
}
