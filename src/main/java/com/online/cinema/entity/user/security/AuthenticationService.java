package com.online.cinema.entity.user.security;

import com.online.cinema.entity.user.model.User;

public interface AuthenticationService {
    User login(String login, String password);

    User register(String email, String password);
}

