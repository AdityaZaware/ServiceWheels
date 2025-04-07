package com.ben.User.Service.controller;

import com.ben.User.Service.dto.MechanicDto;
import com.ben.User.Service.entity.User;
import com.ben.User.Service.request.UserRequest;
import com.ben.User.Service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("create")
    public ResponseEntity<User> registerUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.saveUser(userRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping("mechanic/email/{email}")
    public ResponseEntity<MechanicDto> getMechanicByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getMechanicByEmail(email));
    }


}
