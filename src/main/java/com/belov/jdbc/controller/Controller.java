package com.belov.jdbc.controller;

import com.belov.jdbc.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping("products/fetch-product")
    private String getProductName(@RequestParam("name") String name) {
        return service.getProductName(name);
    }
}
