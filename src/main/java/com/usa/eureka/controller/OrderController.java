package com.usa.eureka.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

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
}
