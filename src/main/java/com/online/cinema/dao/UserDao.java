package com.online.cinema.dao;

import com.online.cinema.entity.User;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByEmail(String email);
}
