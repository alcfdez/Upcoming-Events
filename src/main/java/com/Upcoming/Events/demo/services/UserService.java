package com.Upcoming.Events.demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import com.Upcoming.Events.demo.models.User;
import org.springframework.data.domain.Pageable;


public interface UserService {
    
    
        public List<User> findAll();
    
        public Page<User> findAll(Pageable pageable);
         
        public User  save(User User); 
          
        public  Optional <User> findById(Long id);
         
        public void deleteById(Long id);
         
    }
