package com.example.Inventory.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Inventory.Dtos.CreateProductRequest;
import com.example.Inventory.Model.Inventory;
import com.example.Inventory.Model.Product;
import com.example.Inventory.Repositiories.InventoryRepository;
import com.example.Inventory.Repositiories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final InventoryRepository inventoryRepo;

    @Transactional
    public Long createProduct(CreateProductRequest req) {

        if (productRepo.existsBySku(req.getSku())) {
            throw new RuntimeException("SKU already exists");
        }

        Product p = new Product();
        p.setCompanyId(req.getCompanyId());
        p.setName(req.getName());
        p.setSku(req.getSku());
        p.setPrice(req.getPrice());
        p.setLowStockThreshold(req.getLowStockThreshold());

        productRepo.save(p);

        Inventory inv = new Inventory();
        inv.setProductId(p.getId());
        inv.setWarehouseId(req.getWarehouseId());
        inv.setQuantity(req.getInitialQuantity());

        inventoryRepo.save(inv);

        return p.getId();
    }
}
