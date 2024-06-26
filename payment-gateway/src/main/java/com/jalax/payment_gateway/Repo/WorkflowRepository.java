package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Workflow;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
	
    List<Workflow> findByStatus(String status);

}
