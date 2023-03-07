package com.Upcoming.events.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Upcoming.events.demo.models.Image;

public interface ImageRepository extends JpaRepository <Image, Long> {
    
}
