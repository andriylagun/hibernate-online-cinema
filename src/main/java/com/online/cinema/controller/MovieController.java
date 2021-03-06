package com.online.cinema.controller;

import com.online.cinema.mapper.movie.MovieDtoMapper;
import com.online.cinema.mapper.movie.MovieRequestDto;
import com.online.cinema.mapper.movie.MovieResponseDto;
import com.online.cinema.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movies")
@RestController
public class MovieController {
    private MovieService movieService;
    private MovieDtoMapper movieDtoMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(movieDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addMovie(@RequestBody MovieRequestDto movieRequestDto) {
        movieService.add(movieDtoMapper.fromRequestDto(movieRequestDto));
    }
}
