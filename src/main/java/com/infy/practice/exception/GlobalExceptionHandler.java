package com.infy.practice.exception;

import com.infy.practice.advice.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Custom Exception
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleEmployeeNotFound(ResourceNotFoundException e)
    {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .msg(e.getMessage())
                .build();
        return buildApiErrorResponse(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildApiErrorResponse(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }

    /**
     * Handle all other exception like Arithmetic or ArrayIndexOutofBound or any other.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception e)
    {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .msg(e.getMessage())
                .build();
         return buildApiErrorResponse(apiError);
    }

    /**
     * User Readable error messages define for validation in dto
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationException(MethodArgumentNotValidException e)
    {
        List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .msg("Input Validation Failed.")
                .subErrors(errors)
                .build();
        return buildApiErrorResponse(apiError);
    }
}
