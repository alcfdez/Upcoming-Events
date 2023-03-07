package com.upcoming.events.demo.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.upcoming.events.demo.services.UserServiceImpl;

import antlr.collections.List;

@ExtendWith(MockitoExtension.class)
public class RegisterControllerTest {
    
    @Mock
    private RegisterController registerController;

    @InjectMocks
    private UserServiceImpl uServiceImpl;

    private List<Authority> user;

    @BeforeEach
    public void setUp(){
        
    }

    @Test
    void testCreate() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testGetAll() {

    }

    @Test
    void testUpdate() {

    }
}
