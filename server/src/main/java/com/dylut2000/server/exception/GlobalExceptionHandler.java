package com.dylut2000.server.exception;

import com.dylut2000.server.system.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Result> handleDataNotFoundException(DataNotFoundException e) {
        Result result = new Result(HttpStatus.NOT_FOUND.value(), false, e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnAutororizedException.class)
    public ResponseEntity<Result> handleUnAutororizedException(UnAutororizedException e) {
        Result result = new Result(HttpStatus.UNAUTHORIZED.value(), false, e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }

}
