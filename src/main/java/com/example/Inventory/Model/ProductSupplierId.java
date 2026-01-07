package com.example.Inventory.Model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductSupplierId implements Serializable {
    private Long productId;
    private Long supplierId;
}

