package com.jalax.payment_gateway.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.SupportTicket;
import com.jalax.payment_gateway.Service.SupportTicketService;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {
	
    private final SupportTicketService supportTicketService;

    public SupportTicketController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    @PostMapping("/customers/{customerId}")
    public ResponseEntity<SupportTicket> createSupportTicket(@PathVariable Long customerId, @RequestBody SupportTicket ticket) {
        SupportTicket createdTicket = supportTicketService.createSupportTicket(customerId, ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportTicket> updateSupportTicket(@PathVariable Long id, @RequestBody SupportTicket ticket) {
        SupportTicket updatedTicket = supportTicketService.updateSupportTicket(id, ticket);
        return ResponseEntity.ok(updatedTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> getSupportTicketById(@PathVariable Long id) throws Exception {
        SupportTicket ticket = supportTicketService.getSupportTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping
    public ResponseEntity<List<SupportTicket>> getAllSupportTickets() {
        List<SupportTicket> tickets = supportTicketService.getAllSupportTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<SupportTicket>> getCustomerSupportTickets(@PathVariable Long customerId) throws Exception {
        List<SupportTicket> tickets = supportTicketService.getCustomerSupportTickets(customerId);
        return ResponseEntity.ok(tickets);
    }
}
