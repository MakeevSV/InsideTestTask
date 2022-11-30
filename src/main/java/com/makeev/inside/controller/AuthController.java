package com.makeev.inside.controller;

import com.makeev.inside.dto.UserAuthDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping
    public ResponseEntity auth(@RequestBody UserAuthDto user){

        return new ResponseEntity(HttpStatus.OK);
    }
}
