package com.online.cinema.entity.cinemahall.dao.impl;

import com.online.cinema.dao.GenericDaoImpl;
import com.online.cinema.entity.cinemahall.dao.CinemaHallDao;
import com.online.cinema.entity.cinemahall.model.CinemaHall;
import com.online.cinema.lib.Dao;
import java.util.List;

@Dao
public class CinemaHallDaoImpl extends GenericDaoImpl<CinemaHall>
        implements CinemaHallDao {

    @Override
    public List<CinemaHall> getAll() {
        return super.getAll(CinemaHall.class);
    }
}
