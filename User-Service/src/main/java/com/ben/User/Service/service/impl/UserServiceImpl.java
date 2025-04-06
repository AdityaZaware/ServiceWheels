package com.ben.User.Service.service.impl;

import com.ben.User.Service.entity.User;
import com.ben.User.Service.enums.Role;
import com.ben.User.Service.kafka.KafkaProducer;
import com.ben.User.Service.mapper.UserMapper;
import com.ben.User.Service.repo.UserRepo;
import com.ben.User.Service.request.UserRequest;
import com.ben.User.Service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final KafkaProducer kafkaProducer;

    @Override
    public User saveUser(UserRequest userRequest) {
        User user = userMapper.userRequestToUser(userRequest);

        if(userRequest.getRole().equals(Role.MECHANIC)) {
            kafkaProducer.sendMessage(user.getEmail());
        }

        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return user;
    }
}
