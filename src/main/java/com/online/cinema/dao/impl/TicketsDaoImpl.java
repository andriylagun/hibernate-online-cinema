package com.online.cinema.dao.impl;

import com.online.cinema.dao.TicketsDao;
import com.online.cinema.entity.Ticket;
import com.online.cinema.lib.Dao;
import java.util.List;

@Dao
public class TicketsDaoImpl extends GenericDaoImpl<Ticket> implements TicketsDao {

    @Override
    public List<Ticket> getAll() {
        return super.getAll(Ticket.class);
    }

    @Override
    public Ticket get(Long id) {
        return super.get(Ticket.class, id);
    }
}
