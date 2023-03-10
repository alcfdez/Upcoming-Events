package com.upcoming.events.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upcoming.events.demo.models.Event;

public interface EventRepository extends JpaRepository <Event, Long> {
    
}
