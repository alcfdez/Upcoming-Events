package com.upcoming.events.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.upcoming.events.demo.models.Image;

public interface ImageRepository extends JpaRepository <Image, Long> {
    
}
