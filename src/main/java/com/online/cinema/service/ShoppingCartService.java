package com.online.cinema.service;

import com.online.cinema.entity.MovieSession;
import com.online.cinema.entity.ShoppingCart;
import com.online.cinema.entity.User;

public interface ShoppingCartService {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void addSession(MovieSession movieSession, User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);

    void update(ShoppingCart shoppingCart);
}
