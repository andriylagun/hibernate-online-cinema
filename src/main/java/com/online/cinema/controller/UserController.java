package com.online.cinema.controller;

import com.online.cinema.entity.User;
import com.online.cinema.mapper.user.UserDtoMapper;
import com.online.cinema.mapper.user.UserResponseDto;
import com.online.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    public UserController(UserService userService, UserDtoMapper userDtoMapper) {
        this.userService = userService;
        this.userDtoMapper = userDtoMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).get();
        return userDtoMapper.toResponseDto(user);
    }
}
