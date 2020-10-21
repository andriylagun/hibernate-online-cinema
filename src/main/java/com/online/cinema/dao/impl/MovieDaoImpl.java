package com.online.cinema.dao.impl;

import com.online.cinema.dao.MovieDao;
import com.online.cinema.entity.Movie;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends GenericDaoImpl<Movie> implements MovieDao {

    protected MovieDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Movie> getAll() {
        return super.getAll(Movie.class);
    }

    @Override
    public Movie get(Long id) {
        return super.get(Movie.class, id);
    }

}
