package com.online.cinema.dao.impl;

import com.online.cinema.dao.CinemaHallDao;
import com.online.cinema.entity.CinemaHall;
import com.online.cinema.lib.Dao;
import java.util.List;

@Dao
public class CinemaHallDaoImpl extends GenericDaoImpl<CinemaHall>
        implements CinemaHallDao {

    @Override
    public List<CinemaHall> getAll() {
        return super.getAll(CinemaHall.class);
    }

    @Override
    public CinemaHall get(Long id) {
        return super.get(CinemaHall.class, id);
    }
}
