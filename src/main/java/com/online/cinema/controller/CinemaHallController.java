package com.online.cinema.controller;

import com.online.cinema.mapper.cinemahall.CinemaHallDtoMapper;
import com.online.cinema.mapper.cinemahall.CinemaHallRequestDto;
import com.online.cinema.mapper.cinemahall.CinemaHallResponseDto;
import com.online.cinema.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    public final CinemaHallService cinemaHallService;
    public final CinemaHallDtoMapper cinemaHallDtoMapper;

    public CinemaHallController(
            CinemaHallService cinemaHallService, CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }

    @PostMapping
    public void addCinemaHall(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        cinemaHallService.add(cinemaHallDtoMapper.fromRequestDto(cinemaHallRequestDto));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}