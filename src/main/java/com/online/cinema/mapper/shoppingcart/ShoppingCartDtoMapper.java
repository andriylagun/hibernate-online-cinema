package com.online.cinema.mapper.shoppingcart;

import com.online.cinema.entity.ShoppingCart;
import com.online.cinema.entity.Ticket;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartDtoMapper {
    public ShoppingCartResponseDto toResponseDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setUserId(shoppingCart.getId());
        shoppingCartResponseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }
}
