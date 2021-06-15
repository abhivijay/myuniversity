package com.my.university.utill;

import com.google.common.collect.ImmutableMap;
import com.my.university.dto.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {
    final static String MSG = "errorMessage";

    public ResponseEntity<Object> getSuccessResponse(Object val) {
        if (val instanceof String) {
            return new ResponseEntity<>(new Message((String) val), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getBadRequestMessage(Object val) {
        if (val instanceof String) {
            return new ResponseEntity<>(ImmutableMap.of(MSG, val), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(val, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getInternalServerError(Object val) {
        if (val instanceof String) {
            return new ResponseEntity<>(ImmutableMap.of(MSG, val), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(val, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
