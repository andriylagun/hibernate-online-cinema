package com.online.cinema.service;

import com.online.cinema.entity.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    CinemaHall get(Long cinemaHallId);
}

