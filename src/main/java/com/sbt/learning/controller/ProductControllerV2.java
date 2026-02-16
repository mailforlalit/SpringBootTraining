package com.sbt.learning.controller;

import com.sbt.learning.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
@RestControllerAdvice
public class ProductControllerV2 {

    List<ProductDTO> productList = new ArrayList<>();

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productList;
    }

    @PostMapping("/products")
    public String addProduct(@Valid @RequestBody ProductDTO product) {
        productList.add(product);
        return "products added successfully";
    }
    @PostMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable String id) {
        return productList.get(Integer.parseInt(id));
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        if (e instanceof HttpRequestMethodNotSupportedException) {
            return "Method Not Allowed";
        }
        return "An Error Occurred : " + e.getMessage();
    }
}
