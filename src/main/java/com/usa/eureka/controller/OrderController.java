package com.usa.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/list")
    public String test() {
        return "Hello!";
    }

    @GetMapping("/one")
    public String getOne() {
        return "rand!";
    }
}
