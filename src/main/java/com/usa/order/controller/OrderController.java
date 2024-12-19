package com.usa.order.controller;

import com.usa.order.domain.Order;
import com.usa.order.dto.OrderDto;
import com.usa.order.kafka.KafkaProducer;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
    public ResponseEntity<OrderDto> createOrder(@RequestBody Order order) {
        log.info("order test -> {}", order.toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        OrderDto orderDto = mapper.map(order, OrderDto.class);
        log.info("orderDto test -> {}", orderDto.toString());

        kafkaProducer.send("order", orderDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);

    }
}
