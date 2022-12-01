package com.makeev.inside.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity authError(){
        return new ResponseEntity(Map.of("message","Incorrect credentials"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity incorrectName(){
        return new ResponseEntity<>(Map.of("message","Incorrect name"), HttpStatus.BAD_REQUEST);
    }

}
