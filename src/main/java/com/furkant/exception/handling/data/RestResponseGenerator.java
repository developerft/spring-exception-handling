package com.furkant.exception.handling.data;

import com.furkant.exception.handling.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class RestResponseGenerator {

    public static final String EMPTY_STRING = "";

    public ResponseEntity<Object> success() {

        return success(EMPTY_STRING);
    }

    public <T> ResponseEntity<Object> success(T responseData) {

        return success(responseData, HttpStatus.OK);
    }

    public <T> ResponseEntity<Object> success(T responseData, HttpStatus httpStatus) {
        var response = Response.<T>builder()
                .status(httpStatus.value())
                .data(responseData)
                .success(Boolean.TRUE)
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    public ResponseEntity<Object> error(HttpStatus httpStatus, String error, String errorMessage) {
        var response = Response.builder()
                .status(httpStatus.value())
                .error(error)
                .message(errorMessage)
                .success(Boolean.FALSE)
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    public ResponseEntity<Object> error(HttpStatus httpStatus, String error, String errorMessage, String errorCode) {
        var response = Response.builder()
                .status(httpStatus.value())
                .error(error)
                .errorCode(errorCode)
                .message(errorMessage)
                .success(Boolean.FALSE)
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    public <T> ResponseEntity<Object> error(HttpStatus httpStatus, String error, String errorMessage, T responseData) {
        var response = Response.builder()
                .status(httpStatus.value())
                .error(error)
                .message(errorMessage)
                .data(responseData)
                .success(Boolean.FALSE)
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    public ResponseEntity<Object> badRequest(String errorMessage, ErrorCode errorCode) {
        var response = Response.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(errorCode.getName())
                .errorCode(errorCode.getCode())
                .message(errorMessage)
                .success(Boolean.FALSE)
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> badRequest(ErrorCode errorCode) {
        var response = Response.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(errorCode.getName())
                .errorCode(errorCode.getCode())
                .message(errorCode.getName())
                .success(Boolean.FALSE)
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
