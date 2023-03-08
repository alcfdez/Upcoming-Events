package com.upcoming.events.demo.controllers;

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

import com.upcoming.events.demo.models.User;
import com.upcoming.events.demo.services.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class RegisterController {

 @Autowired
 private UserServiceImpl userService;

 public RegisterController(UserServiceImpl userService) {
  this.userService = userService;
}

@PostMapping(value ="/register")
   public ResponseEntity<?> create(@RequestBody User user) {
    
        try {
          userService.store(user);
          return ResponseEntity.status(201).body(null);          
        } 
        catch (Exception e) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
   }

   
}

