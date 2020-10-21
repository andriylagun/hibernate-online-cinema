package com.online.cinema.dao.impl;

import com.online.cinema.dao.TicketsDao;
import com.online.cinema.entity.Ticket;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketsDaoImpl extends GenericDaoImpl<Ticket> implements TicketsDao {

    protected TicketsDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Ticket> getAll() {
        return super.getAll(Ticket.class);
    }

    @Override
    public Ticket get(Long id) {
        return super.get(Ticket.class, id);
    }
}
