package com.Upcoming.Events.demo.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Upcoming.Events.demo.models.Event;
import com.Upcoming.Events.demo.models.User;
import com.Upcoming.Events.demo.repositories.EventRepository;
import com.Upcoming.Events.demo.repositories.UserRepository;

@Service
public class EventServiceImpl implements BaseService<Event>{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;
    
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    @Transactional 
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Event> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public Optional<Event> findById(Long id) {
       return eventRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
       eventRepository.deleteById(id);
    }

     
    // public void registerUserToEvent(Long eventId, Long userId) {
    //     Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
    //     User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        
    //     if (event.getMax_participants() <= event.getActual_participants()) {
    //         throw new RuntimeException("Event is full");
    //     }
        
    //     event.getUsers().add(user);
    //     event.setActual_participants(event.getActual_participants() + 1);
    //     eventRepository.save(event);
        
    //     user.getEvents().add(event);
    //     userRepository.save(user);
    // }

    public void registerUserToEvent(Long eventId, Long userId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + eventId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
    
        if (event.getUsers().contains(user)) {
            throw new RuntimeException("User is already registered for the event");
        }
    
        if (event.getMax_participants() <= event.getActual_participants()) {
            throw new RuntimeException("Event is full");
        }
    
        event.getUsers().add(user);
        event.setActual_participants(event.getActual_participants() + 1);
        eventRepository.save(event);
    
        user.getEvents().add(event);
        userRepository.save(user);
    }
    
}
