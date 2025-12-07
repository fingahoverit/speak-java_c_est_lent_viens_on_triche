package com.example.springnativedemo.controller;

import com.example.springnativedemo.model.Product;
import com.example.springnativedemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") String id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé : " + id));
    }
}