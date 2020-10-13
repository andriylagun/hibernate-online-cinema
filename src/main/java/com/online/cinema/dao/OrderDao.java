package com.online.cinema.dao;

import com.online.cinema.entity.Order;
import com.online.cinema.entity.User;
import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrderHistory(User user);
}
