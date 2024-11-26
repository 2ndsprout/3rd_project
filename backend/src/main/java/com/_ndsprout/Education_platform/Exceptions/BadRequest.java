package com._ndsprout.Education_platform.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "BAD REQUEST")
public class BadRequest extends RuntimeException{
    public BadRequest(String message){super(message);}
}
