package com.spring.java.phoneshop.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiServiceException {
    public ResourceNotFoundException(String resourceName, Integer resourceId) {
        super(HttpStatus.NOT_FOUND, String.format("%s can't found with id=%d", resourceName, resourceId));
    }
}
