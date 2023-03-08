package com.upcoming.events.demo.config;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.upcoming.events.demo.controllers.RegisterController;
import com.upcoming.events.demo.models.User;
import com.upcoming.events.demo.repositories.UserRepository;

import net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor.Simple;

@ExtendWith(MockitoExtension.class)

public class WebSecurityConfigTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserDetailsService sevice;

    @Test
    void testUserDetails() {
        //given
        String username ="admin";

        //when
        Set<Role> roles = new HashSet<>();
        Role role = new Role("ADMIN", null);
         
        User user = new User("admin", "1234", null);

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());

        when.(repository.findByUsername(username)).thenReturn(Optional.of(user));
        UserDetails userDetails = service.loadUserByUsername(username);

        //Then
        assertThat(userDetails).isNotNull();
        assertThat(userDetails.getUsername()).isEqualTo("username");
        assertThat(userDetails.getPassword()).isEqualTo("1234");
        assertThat(userDetails.getAuthorities().size()).isEqualTo(1);
        assertThat(userDetails.getAuthorities().toArray()).contains(authority);
    }

}
