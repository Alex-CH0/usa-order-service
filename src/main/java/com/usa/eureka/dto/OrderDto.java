package com.usa.eureka.dto;

import com.usa.eureka.domain.Order;
import lombok.Data;
import lombok.Getter;
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
