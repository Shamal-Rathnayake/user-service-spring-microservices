package com.example.user_service.configuration.exceptionHandler;

public class UserNotFoundWIthIdException extends RuntimeException {
    public UserNotFoundWIthIdException(String message) {
        super(message);
    }
}