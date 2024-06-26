package com.jalax.payment_gateway.Controller;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.Message;
import com.jalax.payment_gateway.Service.ChatbotService;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {
	
    private final ChatbotService chatbotService;

    @Autowired
    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message savedMessage = chatbotService.saveMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessagesBySender(@RequestParam(required = false) String sender,
                                                            @RequestParam(required = false) Timestamp start,
                                                            @RequestParam(required = false) Timestamp end) {
        List<Message> messages;
        if (sender != null) {
            messages = chatbotService.getMessagesBySender(sender);
        } else if (start != null && end != null) {
            messages = chatbotService.getMessagesByTimestamp(start, end);
        } else {
            messages = chatbotService.getMessagesBySender("chatbot");
        }
        return ResponseEntity.ok(messages);
    }
}
