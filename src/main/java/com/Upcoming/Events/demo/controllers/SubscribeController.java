package com.Upcoming.Events.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Upcoming.Events.demo.services.SubscribeService;
import org.springframework.web.bind.annotation.PostMapping;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribeToEvent(@RequestParam Long eventId, @RequestParam Long userId) {
        try {
            subscribeService.subscribe(eventId, userId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
