package com.online.cinema.dao.impl;

import com.online.cinema.dao.CinemaHallDao;
import com.online.cinema.entity.CinemaHall;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl extends GenericDaoImpl<CinemaHall>
        implements CinemaHallDao {

    protected CinemaHallDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<CinemaHall> getAll() {
        return super.getAll(CinemaHall.class);
    }

    @Override
    public CinemaHall get(Long id) {
        return super.get(CinemaHall.class, id);
    }
}
