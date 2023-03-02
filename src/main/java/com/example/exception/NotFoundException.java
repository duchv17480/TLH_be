package com.example.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{
    int code;
    String message;

    public NotFoundException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}