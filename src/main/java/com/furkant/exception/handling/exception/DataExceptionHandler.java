package com.furkant.exception.handling.exception;

import com.furkant.exception.handling.data.RestResponseGenerator;
import com.furkant.exception.handling.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class DataExceptionHandler {

    private final RestResponseGenerator restResponseGenerator;

    @ExceptionHandler(UserAlreadySavedException.class)
    public ResponseEntity<Object> userAlreadySavedException(final UserAlreadySavedException e, final WebRequest request) {
        log.error("userAlreadySavedException {}; error message: {}; ", request, e.getMessage(), e);

        return restResponseGenerator.badRequest(e.getMessage(), ErrorCode.USER_ALREADY_SAVED_EXCEPTION);
    }
}
