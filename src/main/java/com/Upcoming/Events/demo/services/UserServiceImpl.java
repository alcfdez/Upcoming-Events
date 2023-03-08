package com.upcoming.events.demo.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.upcoming.events.demo.exception.UserAlreadyExistsException;
import com.upcoming.events.demo.exception.UserServiceException;
import com.upcoming.events.demo.models.User;
import com.upcoming.events.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements BaseService<User>{
    
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User store(User user){

            Optional<User> userOptional = userRepository.findByUsername(user.getUsername()); 
            
            if (userOptional.isPresent()){
                throw new UserAlreadyExistsException("User already exist.");
            }
            try{
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
                return userRepository.save(user);
            }catch (DataAccessException e){
                throw new UserServiceException("User isn't save.",e);
            }

        }        

    @Override
    public List<User> 
    findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User save(User User) {
        return userRepository.save(User);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
         userRepository.deleteById(id);
    }
}
