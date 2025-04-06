package com.ben.User.Service.mapper;

import com.ben.User.Service.entity.User;
import com.ben.User.Service.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {


    public User userRequestToUser(UserRequest userRequest) {
        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .email(userRequest.getEmail())
                .role(userRequest.getRole())
                .build();
    }
}
