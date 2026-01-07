package com.example.Inventory.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(
    name = "products",
    uniqueConstraints = @UniqueConstraint(columnNames = "sku")
)
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;
    private String name;
    private String sku;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private Integer lowStockThreshold;
}
