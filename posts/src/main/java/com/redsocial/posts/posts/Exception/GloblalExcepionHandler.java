package com.redsocial.posts.posts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.redsocial.posts.posts.Model.Payload.ApiResponse;


@RestControllerAdvice
public class GloblalExcepionHandler {

      @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> HandlerResourceNotFoundException(ResourceNotFoundException exception,
            WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(
                exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    
}