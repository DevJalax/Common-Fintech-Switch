package com.jalax.payment_gateway.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Event;
import com.jalax.payment_gateway.Repo.EventRepository;

@Service
public class EventService {
	
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getEventsByUserId(String userId) {
        return eventRepository.findByUserId(userId);
    }

    public List<Event> getEventsByUserIdAndTimestampRange(String userId, LocalDateTime start, LocalDateTime end) {
        return eventRepository.findByUserIdAndTimestampBetween(userId, start, end);
    }
}
