package com.prod_ready_feature.demo.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private HttpStatus status;
    private String error;
    private LocalDateTime timestamp;

    public ApiError(HttpStatus status, String error) {
        this();
        this.status = status;
        this.error = error;
    }

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }
}
