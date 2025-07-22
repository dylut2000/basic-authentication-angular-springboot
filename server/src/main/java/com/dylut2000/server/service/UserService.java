package com.dylut2000.server.service;

import com.dylut2000.server.model.dto.LoginRequestDTO;
import com.dylut2000.server.model.dto.RegisterRequestDTO;
import com.dylut2000.server.model.dto.UserDTO;
import com.dylut2000.server.model.dto.UserTokenDTO;

public interface UserService {

    // REGISTER

    UserDTO register(RegisterRequestDTO registerRequestDTO);

    // LOGIN

    UserTokenDTO login(LoginRequestDTO loginRequestDTO);

}
