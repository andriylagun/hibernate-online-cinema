package com.online.cinema.entity.user.dao;

import com.online.cinema.dao.GenericDao;
import com.online.cinema.entity.user.model.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByEmail(String email);
}
