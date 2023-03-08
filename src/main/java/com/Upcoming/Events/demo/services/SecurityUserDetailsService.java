package com.upcoming.events.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.upcoming.events.demo.repositories.UserRepository;

import com.upcoming.events.demo.security.SecurityUser;

public class SecurityUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository ;
    }

    @Override 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
        .findByUsername(username)
        .map(SecurityUSer::new)
        .orElseThrow(()-> new UsernameNotFoundException("User not found: "+ username));
    }
    
}
