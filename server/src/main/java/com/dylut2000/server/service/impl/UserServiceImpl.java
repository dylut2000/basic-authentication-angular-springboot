package com.dylut2000.server.service.impl;

import com.dylut2000.server.exception.UnAutororizedException;
import com.dylut2000.server.mapper.UserMapper;
import com.dylut2000.server.model.dto.LoginRequestDTO;
import com.dylut2000.server.model.dto.RegisterRequestDTO;
import com.dylut2000.server.model.dto.UserDTO;
import com.dylut2000.server.model.dto.UserTokenDTO;
import com.dylut2000.server.model.entity.User;
import com.dylut2000.server.repository.UserRepository;
import com.dylut2000.server.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

// REGISTER

    @Override
    public UserDTO register(RegisterRequestDTO registerRequestDTO) {

        if (userRepository.existsByUsername(registerRequestDTO.getUsername())) {
            throw new UnAutororizedException("Username already exists!");
        }

        User user = UserMapper.registerRequestToEntity(registerRequestDTO);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        User newUser = userRepository.save(user);

        return UserMapper.userToUserDTO(newUser);
    }



    // LOGIN

    @Override
    public UserTokenDTO login(LoginRequestDTO loginRequestDTO) {

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );

        User user = userRepository.findByUsername(loginRequestDTO.getUsername());

        if (authenticate.isAuthenticated())
            return UserMapper.userToUserTokenDTO(user, jwtService.generateToken(user));

        throw new UnAutororizedException("Invalid credentials!");
    }

}
