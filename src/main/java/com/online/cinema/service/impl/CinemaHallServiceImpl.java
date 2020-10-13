package com.online.cinema.service.impl;

import com.online.cinema.dao.CinemaHallDao;
import com.online.cinema.entity.CinemaHall;
import com.online.cinema.lib.Inject;
import com.online.cinema.lib.Service;
import com.online.cinema.service.CinemaHallService;
import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Inject
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
