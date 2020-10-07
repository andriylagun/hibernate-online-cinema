package com.online.cinema.entity.moviesession.model;

import com.online.cinema.entity.cinemahall.model.CinemaHall;
import com.online.cinema.entity.movie.model.Movie;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_sessions")
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    private CinemaHall cinemaHall;

    private LocalDateTime showTime;
}
