package com.example.Inventory.Repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {}
