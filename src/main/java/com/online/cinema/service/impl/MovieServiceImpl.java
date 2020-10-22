package com.online.cinema.service.impl;

import com.online.cinema.dao.MovieDao;
import com.online.cinema.entity.Movie;
import com.online.cinema.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public Movie get(Long movieId) {
        return movieDao.get(movieId);
    }
}
