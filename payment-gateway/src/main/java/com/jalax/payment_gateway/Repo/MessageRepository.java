package com.jalax.payment_gateway.Repo;

import java.security.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
    List<Message> findBySender(String sender);
    
    List<Message> findByTimestampBetween(Timestamp start, Timestamp end);

}
