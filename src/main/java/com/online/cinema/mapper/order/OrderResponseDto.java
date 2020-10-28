package com.online.cinema.mapper.order;

import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private String orderDate;
}
