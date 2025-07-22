package com.dylut2000.server.mapper;

import com.dylut2000.server.model.dto.RegisterRequestDTO;
import com.dylut2000.server.model.dto.UserDTO;
import com.dylut2000.server.model.dto.UserTokenDTO;
import com.dylut2000.server.model.entity.User;
import com.dylut2000.server.model.enums.UserRole;

public class UserMapper {

    // RegisterRequestDTO to Entity

    public static User registerRequestToEntity(RegisterRequestDTO registerRequestDTO) {

        User user = new User();
        user.setUsername(registerRequestDTO.getUsername());
        user.setPassword(registerRequestDTO.getPassword());

        // GET ROLE
        UserRole role = registerRequestDTO.getRole() != null ? UserRole.valueOf(registerRequestDTO.getRole()) : UserRole.USER;
        user.setRole(role);

        return user;
    }



    // User entity to UserDTO

    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId().toString());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole().name());
        userDTO.setCreatedAt(user.getCreatedAt().toString());
        return userDTO;
    }


    // User entity to UserTokenDTO

    public static UserTokenDTO userToUserTokenDTO(User user, String token) {
        UserTokenDTO userTokenDTO = new UserTokenDTO();
        userTokenDTO.setUser(userToUserDTO(user));
        userTokenDTO.setToken(token);
        return userTokenDTO;
    }


}
