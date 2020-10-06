package com.online.cinema.entity.moviesession.dao;

import com.online.cinema.dao.GenericDao;
import com.online.cinema.entity.moviesession.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao extends GenericDao<MovieSession> {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
}
