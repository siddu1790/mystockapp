package com.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String greeting() {
        return "App is up and running";
    }
}
