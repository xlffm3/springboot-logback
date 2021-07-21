package com.practice.logging.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException() {
        log.info("this is info logging.");
        log.error("this is error logging.");
        log.debug("this is debug logging.");
        return ResponseEntity.ok("exception handled");
    }
}
