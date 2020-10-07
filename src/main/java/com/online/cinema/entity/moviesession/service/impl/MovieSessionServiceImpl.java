package com.online.cinema.entity.moviesession.service.impl;

import com.online.cinema.entity.moviesession.dao.MovieSessionDao;
import com.online.cinema.entity.moviesession.model.MovieSession;
import com.online.cinema.entity.moviesession.service.MovieSessionService;
import com.online.cinema.lib.Inject;
import com.online.cinema.lib.Service;
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
