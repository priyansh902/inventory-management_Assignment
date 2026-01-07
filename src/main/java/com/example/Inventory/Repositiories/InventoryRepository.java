package com.example.Inventory.Repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {}

