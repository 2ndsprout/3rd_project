package com._ndsprout.Education_platform.Records;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
public record TokenRecord(HttpStatus httpStatus, String username, String body) {
    public boolean isOK() {
        return httpStatus.equals(HttpStatus.OK);
    }

    public ResponseEntity<?> getResponseEntity() {
        return ResponseEntity.status(httpStatus).body(body);
    }
}