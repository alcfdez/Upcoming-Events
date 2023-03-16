package com.Upcoming.Events.demo.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.test.annotation.Rollback;

import com.Upcoming.Events.demo.repositories.AuthorityRepository;
import com.Upcoming.Events.demo.repositories.UserRepository;
import com.Upcoming.Events.demo.models.Role;
import com.Upcoming.Events.demo.models.User;


import com.Upcoming.Events.demo.models.User;

import javax.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @Rollback(value = false)
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository rolesRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testUserHaveRoles() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("12345");
    
        Role role = new Role("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "12345", roles,null);
        user.setPassword(password);
    
        rolesRepository.save(role);
        userRepository.save(user);
    
        User userDB = entityManager.find(User.class, user.getId());
    
        // assertEquals(1L, userDB.getId());
        assertEquals(1, userDB.getRoles().size());
        assertThat("User role name", userDB.getRoles().contains(role));
    }
    @Test
    void testName() {
        
    }


}