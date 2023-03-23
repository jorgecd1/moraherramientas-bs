package com.moraherramientas.project.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(Long id){
        super("Could not find the user with id# " + id);
    }
}
