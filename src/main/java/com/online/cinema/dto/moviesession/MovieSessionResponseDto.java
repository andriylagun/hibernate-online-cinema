package com.online.cinema.dto.moviesession;

import lombok.Data;

@Data
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private String sessionDate;
    private String sessionTime;
}
