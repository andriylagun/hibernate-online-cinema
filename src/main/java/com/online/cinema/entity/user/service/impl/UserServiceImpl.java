package com.online.cinema.entity.user.service.impl;

import com.online.cinema.entity.user.dao.UserDao;
import com.online.cinema.entity.user.model.User;
import com.online.cinema.entity.user.service.UserService;
import com.online.cinema.lib.Inject;
import com.online.cinema.lib.Service;
import com.online.cinema.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        byte[] salt = HashUtil.getSalt();
        user.setPassword(HashUtil.hashPassword(user.getPassword(), salt));
        user.setSalt(salt);
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
