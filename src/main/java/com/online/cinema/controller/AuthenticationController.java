package com.online.cinema.controller;

import com.online.cinema.mapper.user.UserRegisterDto;
import com.online.cinema.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/registration")
    private void register(@RequestBody UserRegisterDto userDto) {
        authenticationService.register(userDto.getEmail(), userDto.getPassword());
    }
}
