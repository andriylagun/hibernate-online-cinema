package com.online.cinema.security;

import com.online.cinema.entity.User;
import com.online.cinema.exceptions.AuthenticationException;
import com.online.cinema.service.ShoppingCartService;
import com.online.cinema.service.UserService;
import com.online.cinema.util.HashUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

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
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
