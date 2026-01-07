package com.example.Inventory.Repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySku(String sku);
}

