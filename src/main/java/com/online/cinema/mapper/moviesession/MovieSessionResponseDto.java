package com.online.cinema.mapper.moviesession;

import lombok.Data;

@Data
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private String sessionDateTime;
}
