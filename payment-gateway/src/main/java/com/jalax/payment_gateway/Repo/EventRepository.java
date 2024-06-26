package com.jalax.payment_gateway.Repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
    List<Event> findByUserId(String userId);

    List<Event> findByUserIdAndTimestampBetween(String userId, LocalDateTime start, LocalDateTime end);

}
