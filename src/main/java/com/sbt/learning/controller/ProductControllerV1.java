package com.sbt.learning.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductControllerV1 {

    List<String> productList = new ArrayList<>();

    @GetMapping("/products")
    public List<String> getProducts() {
        return productList;
    }

    @PostMapping("/products")
    public String addProducts(@RequestBody List<String> products) {
        productList.addAll(products);
        return "products added successfully";
    }

}
