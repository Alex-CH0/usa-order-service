package com.usa.eureka.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

//@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
//@Entity
public class Order {

    private String email;

    private Long amount;

}
