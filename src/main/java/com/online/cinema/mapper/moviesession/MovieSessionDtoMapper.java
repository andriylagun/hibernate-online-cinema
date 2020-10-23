package com.online.cinema.mapper.moviesession;

import com.online.cinema.entity.MovieSession;
import com.online.cinema.service.CinemaHallService;
import com.online.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MovieSessionDtoMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionDtoMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSession fromRequestDto(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(
                movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(
                cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(movieSessionRequestDto.getSessionDateTime()));
        return movieSession;
    }

    public MovieSessionResponseDto toResponseDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setSessionDateTime(movieSession.getShowTime().toString());
        return movieSessionResponseDto;
    }
}
