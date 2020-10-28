package com.online.cinema.service;

import com.online.cinema.entity.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User get(Long id);
}
