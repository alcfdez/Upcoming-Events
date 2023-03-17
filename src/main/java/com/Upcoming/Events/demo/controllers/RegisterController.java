package com.Upcoming.Events.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Upcoming.Events.demo.models.User;
import com.Upcoming.Events.demo.services.UserServiceImpl;

@RestController
@RequestMapping("/api/")
public class RegisterController {

    UserServiceImpl service;

    public RegisterController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            service.store(user);
            return ResponseEntity.status(201).body("Register successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e + " Register failed");
        }
    }
}
