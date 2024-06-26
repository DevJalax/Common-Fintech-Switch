package com.jalax.payment_gateway.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.DTO.TicketStatus;
import com.jalax.payment_gateway.Entity.Customer;
import com.jalax.payment_gateway.Entity.SupportTicket;
import com.jalax.payment_gateway.Repo.SupportTicketRepository;

@Service
public class SupportTicketService {
	
    private final SupportTicketRepository supportTicketRepository;
    
    private final CustomerService customerService;

    @Autowired
    public SupportTicketService(SupportTicketRepository supportTicketRepository, CustomerService customerService) {
        this.supportTicketRepository = supportTicketRepository;
        this.customerService = customerService;
    }

    public SupportTicket createSupportTicket(Long customerId, SupportTicket ticket) {
        Customer customer = customerService.getCustomerById(customerId);
        ticket.setCustomer(customer);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setStatus(TicketStatus.OPEN);
        return supportTicketRepository.save(ticket);
    }

    public SupportTicket updateSupportTicket(Long id, SupportTicket updatedTicket) {
        SupportTicket ticket = getSupportTicketById(id);
        ticket.setTitle(updatedTicket.getTitle());
        ticket.setDescription(updatedTicket.getDescription());
        ticket.setStatus(updatedTicket.getStatus());
        ticket.setUpdatedAt(LocalDateTime.now());
        return supportTicketRepository.save(ticket);
    }

    public SupportTicket getSupportTicketById(Long id) throws Exception {
        return supportTicketRepository.findById(id)
                .orElseThrow(() -> new Exception("Support ticket not found with id: " + id));
    }

    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketRepository.findAll();
    }

    public List<SupportTicket> getCustomerSupportTickets(Long customerId) throws Exception {
        Customer customer = customerService.getCustomerById(customerId);
        return supportTicketRepository.findByCustomer(customer);
    }
}
