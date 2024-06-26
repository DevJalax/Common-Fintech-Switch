package com.jalax.payment_gateway.Repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
	List<Transaction> findByCardNumberAndTimestampBetween(String cardNumber, LocalDateTime startDate, LocalDateTime endDate);

}