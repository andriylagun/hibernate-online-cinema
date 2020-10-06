package com.online.cinema.entity.cinemahall.service;

import com.online.cinema.entity.cinemahall.model.CinemaHall;

import java.util.List;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}

