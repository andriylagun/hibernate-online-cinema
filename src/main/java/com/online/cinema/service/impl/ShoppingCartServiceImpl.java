package com.online.cinema.service.impl;

import com.online.cinema.dao.ShoppingCartDao;
import com.online.cinema.dao.TicketsDao;
import com.online.cinema.entity.MovieSession;
import com.online.cinema.entity.ShoppingCart;
import com.online.cinema.entity.Ticket;
import com.online.cinema.entity.User;
import com.online.cinema.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartDao shoppingCartDao;
    private TicketsDao ticketsDao;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketsDao ticketsDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketsDao = ticketsDao;
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        return shoppingCartDao.add(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user).get();
    }

    @Override
    public void addSession(MovieSession movieSession, User user) {
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user).get();
        Ticket ticket = Ticket.builder()
                .movieSession(movieSession)
                .user(user)
                .build();
        ticketsDao.add(ticket);
        shoppingCart.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        add(ShoppingCart.builder()
                .user(user)
                .build());
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        update(shoppingCart);
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        shoppingCartDao.update(shoppingCart);
    }
}
