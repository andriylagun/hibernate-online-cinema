package com.online.cinema.service.impl;

import com.online.cinema.dao.MovieSessionDao;
import com.online.cinema.entity.MovieSession;
import com.online.cinema.lib.Inject;
import com.online.cinema.lib.Service;
import com.online.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }
}
