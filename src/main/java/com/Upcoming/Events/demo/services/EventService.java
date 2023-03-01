package com.Upcoming.Events.demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.Upcoming.Events.demo.models.Event;


public interface EventService {
    
        
        public List<Event> findAll();

        public Page<Event> findAll(Pageable pageable);
    
        public Event save(Event Event);
    
        public Optional <Event> findById(Long id);
    
        public void deleteById(Long id);

    }
