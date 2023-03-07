package com.upcoming.events.demo.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException (String message){
        super(message);
    }

    public UserAlreadyExistsException (String message, Throwable cause){
        super(message, cause);
    }
    
}
