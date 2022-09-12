package com.example.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class Controller {

    @GetMapping
    String sayName() {
        return "Gateway";
    }
}
