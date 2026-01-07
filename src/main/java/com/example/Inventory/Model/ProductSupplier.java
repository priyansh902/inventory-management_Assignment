package com.example.Inventory.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_supplier")
@Data
@IdClass(ProductSupplierId.class)
public class ProductSupplier {
    @Id
    private Long productId;
    @Id
    private Long supplierId;
}
