package com.online.cinema.entity.movie.service;

import com.online.cinema.entity.movie.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
