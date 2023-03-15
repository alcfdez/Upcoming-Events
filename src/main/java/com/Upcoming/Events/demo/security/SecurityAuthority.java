package com.upcoming.events.demo.security;

import org.springframework.security.core.GrantedAuthority;
<<<<<<< HEAD
=======

>>>>>>> 0be9e50ad31fa4a93d67b6de711199d9ed629d89
import com.upcoming.events.demo.models.Authority;


public class SecurityAuthority implements GrantedAuthority{
    
    private final Authority authority;

 
    public SecurityAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}

