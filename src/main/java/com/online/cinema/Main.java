package com.online.cinema;

import com.online.cinema.entity.CinemaHall;
import com.online.cinema.entity.Movie;
import com.online.cinema.entity.MovieSession;
import com.online.cinema.entity.User;
import com.online.cinema.exceptions.AuthenticationException;
import com.online.cinema.lib.Injector;
import com.online.cinema.security.AuthenticationService;
import com.online.cinema.service.CinemaHallService;
import com.online.cinema.service.MovieService;
import com.online.cinema.service.MovieSessionService;
import com.online.cinema.service.ShoppingCartService;
import com.online.cinema.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("com.online.cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        Movie movie1 = new Movie();
        movie1.setTitle("Movie1");
        movieService.add(movie1);
        Movie movie2 = new Movie();
        movie2.setTitle("Movie2");
        movieService.add(movie2);
        movieService.getAll().forEach(System.out::println);

        CinemaHallService cinemaHallService
                = (CinemaHallService) injector.getInstance(CinemaHallService.class);

        CinemaHall cinemaHall1 = new CinemaHall();
        cinemaHall1.setDescription("HALL NUMBER ONE");
        cinemaHallService.add(cinemaHall1);
        CinemaHall cinemaHall2 = new CinemaHall();
        cinemaHall2.setDescription("HALL NUMBER TWO");
        cinemaHallService.add(cinemaHall2);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession1 = new MovieSession();
        movieSession1.setCinemaHall(cinemaHall1);
        movieSession1.setMovie(movie1);
        movieSession1.setShowTime(LocalDateTime.of(2020, 10, 20, 15, 30));

        MovieSessionService movieSessionService
                = (MovieSessionService) injector.getInstance(MovieSessionService.class);

        movieSessionService.add(movieSession1);
        MovieSession movieSession2 = new MovieSession();
        movieSession2.setCinemaHall(cinemaHall2);
        movieSession2.setMovie(movie2);
        movieSession2.setShowTime(LocalDateTime.of(2020, 10, 22, 15, 30));
        movieSessionService.add(movieSession2);
        System.out.println(movieSessionService
                .findAvailableSessions(1L, LocalDate.of(2020, 10, 20)));

        System.out.println(movieSessionService
                .findAvailableSessions(2L, LocalDate.of(2020, 10, 22)));

        UserService userService
                = (UserService) injector.getInstance(UserService.class);
        AuthenticationService authenticationService
                = (AuthenticationService) injector.getInstance(AuthenticationService.class);
        authenticationService.register("user1@gmail.com", "pass");
        authenticationService.register("user2@gmail.com", "pass");
        User user = userService.findByEmail("user1@gmail.com").get();
        System.out.println(user.toString());
        try {
            System.out.println(authenticationService.login("user2@gmail.com", "pass").toString());
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        ShoppingCartService shoppingCartService
                = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        shoppingCartService.addSession(movieSession1, user);
        shoppingCartService.addSession(movieSession2, user);
        System.out.println(shoppingCartService.getByUser(user));
        shoppingCartService.clear(shoppingCartService.getByUser(user));
        shoppingCartService.addSession(movieSession2, user);
        System.out.println(shoppingCartService.getByUser(user));
    }
}
