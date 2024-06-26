package com.jalax.payment_gateway.Service;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Message;
import com.jalax.payment_gateway.Repo.MessageRepository;

@Service
public class ChatbotService {
	
    private final MessageRepository messageRepository;

    @Autowired
    public ChatbotService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessagesBySender(String sender) {
        return messageRepository.findBySender(sender);
    }

    public List<Message> getMessagesByTimestamp(Timestamp start, Timestamp end) {
        return messageRepository.findByTimestampBetween(start, end);
    }
}
