package com.Upcoming.events.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Upcoming.events.demo.models.User;

public interface UserRepository extends JpaRepository <User, Long> {
    
}
