package com.dylut2000.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String welcome() {
        return "<h1 style='text-align:center; font-family: sans-serif; font-size: 4rem; margin-top: 4rem'>The Server is UP!</h1>";
    }

}
