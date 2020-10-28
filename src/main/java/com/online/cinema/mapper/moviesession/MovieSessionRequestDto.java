package com.online.cinema.mapper.moviesession;

import lombok.Data;

@Data
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private String sessionDateTime;
}
