package com.online.cinema.entity.user.service;

import com.online.cinema.entity.user.model.User;

public interface UserService {
    User add(User user);

    User findByEmail(String email);
}