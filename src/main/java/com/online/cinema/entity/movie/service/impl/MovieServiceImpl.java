package com.online.cinema.entity.movie.service.impl;

import com.online.cinema.entity.movie.dao.MovieDao;
import com.online.cinema.entity.movie.model.Movie;
import com.online.cinema.entity.movie.service.MovieService;
import com.online.cinema.lib.Inject;
import com.online.cinema.lib.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
