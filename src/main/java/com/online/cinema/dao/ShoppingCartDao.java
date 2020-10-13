package com.online.cinema.dao;

import com.online.cinema.entity.ShoppingCart;
import com.online.cinema.entity.User;
import java.util.Optional;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    Optional<ShoppingCart> getByUser(User user);
}
