package com.example.Inventory.Controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inventory.Dtos.CreateProductRequest;
import com.example.Inventory.Service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductRequest req) {
        Long id = service.createProduct(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("product_id", id));
    }
}

