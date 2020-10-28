package com.online.cinema.controller;

import com.online.cinema.entity.MovieSession;
import com.online.cinema.entity.User;
import com.online.cinema.mapper.shoppingcart.ShoppingCartDtoMapper;
import com.online.cinema.mapper.shoppingcart.ShoppingCartResponseDto;
import com.online.cinema.service.MovieSessionService;
import com.online.cinema.service.ShoppingCartService;
import com.online.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartDtoMapper shoppingCartDtoMapper;

    public ShoppingCartController(MovieSessionService movieSessionService, UserService userService,
                                  ShoppingCartService shoppingCartService,
                                  ShoppingCartDtoMapper shoppingCartDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartDtoMapper = shoppingCartDtoMapper;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long movieSessionId, @RequestParam Long userId) {
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCartByUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        return shoppingCartDtoMapper.toResponseDto(shoppingCartService.getByUser(user));
    }
}
