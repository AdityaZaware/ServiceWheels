package com.ben.User.Service.service.impl;

import com.ben.User.Service.dto.MechanicDto;
import com.ben.User.Service.dto.ShopDto;
import com.ben.User.Service.entity.User;
import com.ben.User.Service.enums.Role;
import com.ben.User.Service.external.ShopService;
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
    private final ShopService shopService;

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

    @Override
    public MechanicDto getMechanicByEmail(String email) {
        User user = userRepo.findByEmail(email);

        if(user.getRole() != Role.MECHANIC) {
            throw new RuntimeException("User is not a mechanic");
        }

        ShopDto shopDto = shopService.getShopByOwnerEmail(email);

        MechanicDto mechanicDto = new MechanicDto();
        mechanicDto.setId(user.getId());
        mechanicDto.setEmail(user.getEmail());
        mechanicDto.setShopDto(shopDto);

        return mechanicDto;
    }
}
