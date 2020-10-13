package com.online.cinema.service;

import com.online.cinema.entity.Order;
import com.online.cinema.entity.ShoppingCart;
import com.online.cinema.entity.User;
import java.util.List;

public interface OrderService {
    Order add(Order order);

    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrderHistory(User user);
}
