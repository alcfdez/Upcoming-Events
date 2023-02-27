package com.Upcoming.Events.demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Upcoming.Events.demo.models.User;
import com.Upcoming.Events.demo.repositories.UserRepository;

@Service
public class UserService {
    
        private UserRepository repository;
    
        public UserService(UserRepository repository){
            this.repository = repository;
        }
    
        public List<User> getAll(){
            return repository.findAll();
        }
    
        public User getOne(Long id) {
            User User = repository.findById(id).orElse(null);
            return User;
        }
    
        public User  save(User User) {
            User UserSaved = repository.save(User);
            return UserSaved;
        }
    
        public static Optional <User> findById(Long id){
            return null;
        }
    
        public List<User> delete(Long id){
            repository.deleteById(id);
            return repository.findAll();
        }
    }
