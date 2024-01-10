package com.belov.jdbc.controller;

import com.belov.jdbc.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("products/fetch-product")
    private String getProductName(@RequestParam("name") String name) {
        return service.getProductName(name);
    }
}
