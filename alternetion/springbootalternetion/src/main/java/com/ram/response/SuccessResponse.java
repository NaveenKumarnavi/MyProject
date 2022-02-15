package com.ram.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SuccessResponse {
    public static ResponseEntity<Object> handleUserNotFoundException;

    public static ResponseEntity<Object> success(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put(" timestamp", status.value());
      
      

        return new ResponseEntity<Object>(map,status);
    }
}
