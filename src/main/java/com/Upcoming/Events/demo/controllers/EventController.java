package com.Upcoming.Events.demo.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Upcoming.Events.demo.models.Event;
import com.Upcoming.Events.demo.services.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
    
    @Autowired
    private EventService eventService;
    
//Crear nuevo usuario
    @PostMapping 
    public ResponseEntity<?> create(@RequestBody Event event) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(event));
 }
//Leer un usuario
@GetMapping
public List<Event> getAll() {
    return eventService.findAll();
}

//Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Event eventDetails, @PathVariable Long id)  {
        Optional<Event> event = eventService.findById(id);
        if (!event.isPresent()) {
            return ResponseEntity.notFound().build();
    }

    event.get().setTitle(eventDetails.getTitle());
    event.get().setDate_hour(eventDetails.getDate_hour());
    event.get().setMax_participants(eventDetails.getMax_participants());
    event.get().setDescription(eventDetails.getDescription());
    // event.get().setId_image(eventDetails.getId_image());
    event.get().setActual_participants(eventDetails.getActual_participants());

    return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(event.get()));

}

//Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!eventService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        eventService.deleteById(id);
        return ResponseEntity.ok().build();

}
}
