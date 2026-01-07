package com.example.Inventory.Repositiories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Inventory.Dtos.LowStockAlertProjection;
import com.example.Inventory.Model.Product;


@Repository
public interface AlertRepository extends JpaRepository<Product, Long> {

    @Query("""
    SELECT
        p.id AS productId,
        p.name AS productName,
        p.sku AS sku,
        w.id AS warehouseId,
        w.name AS warehouseName,
        i.quantity AS currentStock,
        p.lowStockThreshold AS threshold,
        sup.id AS supplierId,
        sup.name AS supplierName,
        sup.contactEmail AS supplierEmail,
        SUM(s.quantity) AS totalSoldLast30Days
    FROM Product p
    JOIN Inventory i ON i.productId = p.id
    JOIN Warehouse w ON w.id = i.warehouseId
    JOIN Sales s ON s.productId = p.id AND s.warehouseId = w.id
    JOIN ProductSupplier ps ON ps.productId = p.id
    JOIN Supplier sup ON sup.id = ps.supplierId
    WHERE p.companyId = :companyId
      AND s.soldAt >= :cutoff
      AND i.quantity < p.lowStockThreshold
    GROUP BY
        p.id, p.name, p.sku,
        w.id, w.name,
        i.quantity,
        p.lowStockThreshold,
        sup.id, sup.name, sup.contactEmail
    """)
    List<LowStockAlertProjection> findLowStockAlerts(
        @Param("companyId") Long companyId,
        @Param("cutoff") LocalDateTime cutoff
    );
}
