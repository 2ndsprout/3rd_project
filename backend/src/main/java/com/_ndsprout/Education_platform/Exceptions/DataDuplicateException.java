package com._ndsprout.Education_platform.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "data duplicate found")
public class DataDuplicateException extends RuntimeException {
    public DataDuplicateException(String message) {
        super(message);
    }
}