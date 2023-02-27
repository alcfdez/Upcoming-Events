package com.Upcoming.Events.demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Upcoming.Events.demo.models.Event;
import com.Upcoming.Events.demo.repositories.EventRepository;

@Service
public class EventService {
    
        private EventRepository repository;
    
        public EventService(EventRepository repository){
            this.repository = repository;
        }
    
        public List<Event> getAll(){
            return repository.findAll();
        }
    
        public Event getOne(Long id) {
           Event Event = repository.findById(id).orElse(null);
            return Event;
        }
    
        public Event  save(Event Event) {
            Event EventSaved = repository.save(Event);
            return EventSaved;
        }
    
        public Optional <Event> findById(Long id){
            return null;
        }
    
        public List<Event> delete(Long id){
            repository.deleteById(id);
            return repository.findAll();
        }

        public void deleteById(Long id) {
        }
    }
