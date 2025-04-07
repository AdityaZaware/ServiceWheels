package com.ben.User.Service.service;

import com.ben.User.Service.dto.MechanicDto;
import com.ben.User.Service.entity.User;
import com.ben.User.Service.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User saveUser(UserRequest userRequest);

    User getUserById(Long id);

    User getUserByEmail(String email);

    MechanicDto getMechanicByEmail(String email);
}
