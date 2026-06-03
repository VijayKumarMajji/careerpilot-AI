package com.careerpilot.controller;

import com.careerpilot.dto.UserRegistrationRequest;
import com.careerpilot.entity.User;
import com.careerpilot.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRegistrationRequest request) {

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role("USER")
                .build();

        return userService.saveUser(user);
    }
}