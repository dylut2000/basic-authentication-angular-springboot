package com.dylut2000.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenDTO {

    // might be needed

    private String token;
    private UserDTO user;

}
