package com.Upcoming.Events.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Upcoming.Events.demo.models.Role;

public interface AuthorityRepository extends JpaRepository<Role, Long> {
    
}
