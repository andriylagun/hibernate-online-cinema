package com.online.cinema.entity.movie.dao.impl;

import com.online.cinema.dao.GenericDaoImpl;
import com.online.cinema.entity.movie.dao.MovieDao;
import com.online.cinema.lib.Dao;
import com.online.cinema.entity.movie.model.Movie;
import java.util.List;

@Dao
public class MovieDaoImpl extends GenericDaoImpl<Movie> implements MovieDao{

    @Override
    public List<Movie> getAll() {
        return super.getAll(Movie.class);
    }

}
