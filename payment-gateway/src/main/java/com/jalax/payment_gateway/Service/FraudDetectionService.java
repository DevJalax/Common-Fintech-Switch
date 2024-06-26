package com.jalax.payment_gateway.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Transaction;
import com.jalax.payment_gateway.Repo.TransactionRepository;

@Service
public class FraudDetectionService {
	
    private final TransactionRepository transactionRepository;

    @Autowired
    public FraudDetectionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactionsByCardNumberAndDateRange(String cardNumber, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByCardNumberAndTimestampBetween(cardNumber, startDate, endDate);
    }

    public Transaction markTransactionAsFraudulent(Long transactionId) throws Exception {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new Exception("Transaction not found"));

        transaction.setFraudulent(true);
        return transactionRepository.save(transaction);
    }
}
