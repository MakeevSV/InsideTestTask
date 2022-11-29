package com.makeev.inside.controller;

import com.makeev.inside.dto.UserAuthDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping
    public void auth(@RequestBody UserAuthDto user){

    }
}
