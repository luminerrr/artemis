package com.example.artemis.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(
        String message,
        HttpStatus status,
        Integer count,
        Object responseObject
    ) {
        Map<String,  Object> response = new HashMap<String, Object>();
        response.put("message", message);
        response.put("status", status.value());
        response.put("count", count);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, status);
    }
}
