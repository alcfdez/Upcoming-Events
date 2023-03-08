package com.Upcoming.Events.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Upcoming.Events.demo.models.Event;
import com.Upcoming.Events.demo.models.User;
import com.Upcoming.Events.demo.repositories.EventRepository;
import com.Upcoming.Events.demo.repositories.UserRepository;

@Service
public class SubscribeService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public SubscribeService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

   public void subscribe(Long eventId, Long userId) {

    Optional<Event> oEvent = eventRepository.findById(eventId);
    Optional<User> oUser = userRepository.findById(userId);

    if(oEvent.isPresent() && oUser.isPresent()) {
        // System.out.println(oEvent);
        Event event = oEvent.get();
        User user = oUser.get();
        event.getUsers().add(user);
        user.getEvents().add(event);
        eventRepository.save(event);
    } else {
        throw new IllegalStateException("Event or user not found");
    }

   }
}
