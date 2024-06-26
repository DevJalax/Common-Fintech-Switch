package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
    List<Task> findByWorkflowId(Long workflowId);

    List<Task> findByStatus(String status);

}
