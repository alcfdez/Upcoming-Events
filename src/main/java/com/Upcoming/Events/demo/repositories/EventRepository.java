package com.Upcoming.events.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Upcoming.events.demo.models.Event;

public interface EventRepository extends JpaRepository <Event, Long> {
    
}
