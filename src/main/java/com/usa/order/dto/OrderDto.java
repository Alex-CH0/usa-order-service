package com.usa.order.dto;

import com.usa.order.domain.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderDto {

    private String email;
    private Long amount;

    public OrderDto(Order order) {
        this.email = order.getEmail();
        this.amount = order.getAmount();
    }
}
