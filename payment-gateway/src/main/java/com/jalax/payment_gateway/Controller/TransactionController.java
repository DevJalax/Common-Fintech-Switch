package com.jalax.payment_gateway.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.Transaction;
import com.jalax.payment_gateway.Service.FraudDetectionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
    private final FraudDetectionService fraudDetectionService;

    @Autowired
    public TransactionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactionsByCardNumberAndDateRange(
            @RequestParam String cardNumber,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<Transaction> transactions = fraudDetectionService.getTransactionsByCardNumberAndDateRange(cardNumber, startDate, endDate);
        return ResponseEntity.ok(transactions);
    }

    @PutMapping("/{id}/mark-as-fraudulent")
    public ResponseEntity<Transaction> markTransactionAsFraudulent(@PathVariable Long id) throws Exception {
        Transaction transaction = fraudDetectionService.markTransactionAsFraudulent(id);
        return ResponseEntity.ok(transaction);
    }
}