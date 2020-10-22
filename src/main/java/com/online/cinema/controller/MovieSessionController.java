package com.online.cinema.controller;

import com.online.cinema.dto.moviesession.MovieSessionDtoMapper;
import com.online.cinema.dto.moviesession.MovieSessionRequestDto;
import com.online.cinema.dto.moviesession.MovieSessionResponseDto;
import com.online.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/movie-sessions")
@RestController
public class MovieSessionController {
    private MovieSessionService movieSessionService;
    private MovieSessionDtoMapper movieSessionDtoMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
            MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public RedirectView addMovieSession(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionService.add(movieSessionDtoMapper.fromRequestDto(movieSessionRequestDto));
        return new RedirectView("/avaliable");
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailableSessions(Long movieId, String date) {
        return movieSessionService.findAvailableSessions(movieId, LocalDate.parse(date))
                .stream()
                .map(movieSessionDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
