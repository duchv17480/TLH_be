package com.example.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class DefaultResponse <T> {

    private Integer success;
    private String message;
    private T data;

    public static <T> DefaultResponse<T> success(String message) {
        DefaultResponse<T> response = new DefaultResponse<>();
        response.setSuccess(HttpStatus.OK.value());
        response.setMessage(message);

        return response;
    }
}
