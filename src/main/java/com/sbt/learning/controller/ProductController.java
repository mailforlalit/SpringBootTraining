package com.sbt.learning.controller;

import com.sbt.learning.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name="Product API", description="API for Managing Products")
public class ProductController {

    List<ProductDTO> products = new ArrayList<>();

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return products;
    }

    @PostMapping("/products")
    public String addProducts(@RequestBody ProductDTO product) {
        products.add(product);
        return "product added successfully";
    }

    @DeleteMapping("/product/{id}")
    @Parameter(description="ID to delete the product", example = "0")
    public String deleteProduct(@PathVariable String id) {
        products.remove(id);
        return "products deleted successfully";
    }

    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Integer id, @RequestBody ProductDTO product) {
        products.set(id,product);
        return "product updated successfully";
    }

    @PatchMapping("/products/{id}")
    public String patchProductWithPrice(@PathVariable Integer id, @RequestBody ProductDTO product) {
        ProductDTO locProduct = products.get(id);
        locProduct.setProductPrice(product.getProductPrice());
        products.set(id,locProduct);
        return "product updated successfully";
    }


    @PatchMapping("/products/single/{id}")
    public String updateOnlyProductPrice(@PathVariable int id, @RequestParam double price) {
        ProductDTO p = products.get(id);
        p.setProductPrice(price);
        return "Product price updated successfully";
    }
}
