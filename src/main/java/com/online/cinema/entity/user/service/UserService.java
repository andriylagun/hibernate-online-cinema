package com.online.cinema.entity.user.service;

import com.online.cinema.entity.user.model.User;

import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}