package com.upcoming.events.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upcoming.events.demo.models.User;

public interface UserRepository extends JpaRepository <User, Long> {
    
    Optional<User>findByUsername(String username);
}
