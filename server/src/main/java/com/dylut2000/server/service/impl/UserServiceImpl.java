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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


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

    @Override
    public UserTokenDTO login(LoginRequestDTO loginRequestDTO) {
        return null;
    }
}
