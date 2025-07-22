package com.dylut2000.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // REGISTER USER

    @PostMapping("/register")
    public String register() {
        return "User registered successfully!";
    }


    // LOGIN USER

    @PostMapping("/login")
    public String login() {
        return "User logged in successfully!";
    }


}
