package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalax.payment_gateway.Entity.Customer;
import com.jalax.payment_gateway.Entity.SupportTicket;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
	
    List<SupportTicket> findByCustomer(Customer customer);

}
