package com.usa.eureka.dto;

import com.usa.eureka.domain.Order;
import lombok.Getter;

@Getter
public class OrderDto {

    private final String email;
    private final Long amount;

    public OrderDto(Order order){
        this.email = order.getEmail();
        this.amount = order.getAmount();
    }
}
