package com.dylut2000.server.controller;

import com.dylut2000.server.model.dto.LoginRequestDTO;
import com.dylut2000.server.model.dto.RegisterRequestDTO;
import com.dylut2000.server.model.dto.UserDTO;
import com.dylut2000.server.model.dto.UserTokenDTO;
import com.dylut2000.server.service.UserService;
import com.dylut2000.server.system.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER USER

    @PostMapping("/register")
    public ResponseEntity<Result> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        UserDTO userDTO = userService.register(registerRequestDTO);
        Result result = new Result(200, true, "User registered successfully!", userDTO);
        return ResponseEntity.ok(result);
    }


    // LOGIN USER

    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        UserTokenDTO userTokenDTO = userService.login(loginRequestDTO);
        Result result = new Result(200, true, "User logged in successfully!", userTokenDTO);
        return ResponseEntity.ok(result);
    }


}
