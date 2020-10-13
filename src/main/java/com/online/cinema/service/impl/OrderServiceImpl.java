package com.online.cinema.service.impl;

import com.online.cinema.dao.OrderDao;
import com.online.cinema.entity.Order;
import com.online.cinema.entity.ShoppingCart;
import com.online.cinema.entity.User;
import com.online.cinema.lib.Inject;
import com.online.cinema.lib.Service;
import com.online.cinema.service.OrderService;
import com.online.cinema.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = Order.builder()
                .orderDate(LocalDateTime.now())
                .user(shoppingCart.getUser())
                .tickets(new ArrayList<>(shoppingCart.getTickets()))
                .build();
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}
