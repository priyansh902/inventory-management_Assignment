package com.example.Inventory.Dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateProductRequest {
    private Long companyId;
    private String name;
    private String sku;
    private BigDecimal price;
    private Integer initialQuantity;
    private Long warehouseId;
    private Integer lowStockThreshold;
}
