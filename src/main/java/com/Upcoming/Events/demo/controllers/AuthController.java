package com.Upcoming.Events.demo.controllers;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<Map<String, String>> access() {

        var auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, String> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("role", auth.getAuthorities().iterator().next().toString());
        json.put("username : ", auth.getName());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }

    @GetMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletRequest request) {
        SecurityContextHolder.clearContext();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        Map<String, String> json = new HashMap<>();
        json.put("message", "Logged out");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
