package com.dylut2000.server.service.impl;

import com.dylut2000.server.CustomUserDetails;
import com.dylut2000.server.exception.DataNotFoundException;
import com.dylut2000.server.model.entity.User;
import com.dylut2000.server.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            System.out.println("User not found");
            throw new DataNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
