package com.projects.webapi.exception;

public class UsernameAlreadyExists extends RuntimeException{
    public UsernameAlreadyExists(String message) {
        super(message);
    }
}
