package com.online.cinema.service;

import com.online.cinema.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
