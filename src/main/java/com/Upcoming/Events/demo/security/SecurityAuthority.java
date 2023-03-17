package com.Upcoming.Events.demo.security;

import org.springframework.security.core.GrantedAuthority;

import com.Upcoming.Events.demo.models.Role;

public class SecurityAuthority implements GrantedAuthority {

    private final Role authority;

    public SecurityAuthority(Role authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getRoleName();
    }
}
