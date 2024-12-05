package com.usa.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/members")
@RestController
public class MemberController {

    @GetMapping("/test")
    public String test() {
        return "Hello!";
    }

    @GetMapping("/actutest")
    public String actutest() {
        return "actutest!";
    }
}
