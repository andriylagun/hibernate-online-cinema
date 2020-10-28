package com.online.cinema.controller;

import com.online.cinema.entity.Order;
import com.online.cinema.entity.ShoppingCart;
import com.online.cinema.entity.User;
import com.online.cinema.mapper.order.OrderDtoMapper;
import com.online.cinema.mapper.order.OrderResponseDto;
import com.online.cinema.service.OrderService;
import com.online.cinema.service.ShoppingCartService;
import com.online.cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final OrderDtoMapper orderDtoMapper;

    public OrderController(UserService userService, ShoppingCartService shoppingCartService,
                           OrderService orderService, OrderDtoMapper orderDtoMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderDtoMapper = orderDtoMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        Order order = orderService.completeOrder(shoppingCart);
        return orderDtoMapper.toResponseDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistoryOfUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        return orderService.getOrderHistory(user)
                .stream()
                .map(orderDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
