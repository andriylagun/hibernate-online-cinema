package com.online.cinema.dao.impl;

import com.online.cinema.dao.MovieDao;
import com.online.cinema.entity.Movie;
import com.online.cinema.lib.Dao;
import java.util.List;

@Dao
public class MovieDaoImpl extends GenericDaoImpl<Movie> implements MovieDao {

    @Override
    public List<Movie> getAll() {
        return super.getAll(Movie.class);
    }

    @Override
    public Movie get(Long id) {
        return super.get(Movie.class, id);
    }

}
