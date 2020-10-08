package com.online.cinema.entity.user.security;

import com.online.cinema.entity.user.model.User;
import com.online.cinema.exceptions.AuthenticationException;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;

    User register(String email, String password);
}

