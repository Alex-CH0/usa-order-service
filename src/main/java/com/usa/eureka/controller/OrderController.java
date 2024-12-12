package com.usa.eureka.controller;

import com.usa.eureka.domain.Order;
import com.usa.eureka.dto.OrderDto;
import com.usa.eureka.kafka.KafkaProducer;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/list")
    public String test() {
        return "Order list : []!";
    }

    @GetMapping("/one")
    public String getOne() {
        return "rand!";
    }

    @GetMapping("/info")
    public String getInfo(HttpServletRequest request) {
        return "Server on Port :" + request.getServerPort();
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        log.info("order test -> {}", order.toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        kafkaProducer.send("order-user-topic", mapper.map(order, OrderDto.class));

        return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }
}
