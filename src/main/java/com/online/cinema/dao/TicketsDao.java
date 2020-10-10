package com.online.cinema.dao;

import com.online.cinema.entity.Ticket;

public interface TicketsDao extends GenericDao<Ticket> {
    Ticket add(Ticket ticket);
}
