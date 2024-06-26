package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.AutomationTask;

@Repository
public interface AutomationTaskRepository extends JpaRepository<AutomationTask, Long> {
    List<AutomationTask> findByActiveTrue();
}
