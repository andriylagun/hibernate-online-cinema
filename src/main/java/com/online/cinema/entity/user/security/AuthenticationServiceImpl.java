package com.online.cinema.entity.user.security;

import com.online.cinema.entity.user.model.User;
import com.online.cinema.entity.user.service.UserService;
import com.online.cinema.exceptions.AuthenticationException;
import com.online.cinema.lib.Inject;
import com.online.cinema.lib.Service;
import com.online.cinema.util.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isEmpty() || !HashUtil.hashPassword(password, user.get().getSalt())
                .equals(user.get().getPassword())) {
            throw new AuthenticationException("Your login or password is incorrect."
                    + " Please try again.");
        }
        return user.get();
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userService.add(user);
    }
}
