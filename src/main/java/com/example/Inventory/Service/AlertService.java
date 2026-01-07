package com.example.Inventory.Service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Inventory.Repositiories.AlertRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository repo;

    public Map<String, Object> getLowStockAlerts(Long companyId) {
        LocalDateTime cutoff = LocalDateTime.now().minusDays(30);

        var raw = repo.findLowStockAlerts(companyId, cutoff);

        var alerts = raw.stream().map(a -> {
            Integer days = null;

            if (a.getTotalSoldLast30Days() != null && a.getTotalSoldLast30Days() > 0) {
                double avgDaily = a.getTotalSoldLast30Days() / 30.0;
                days = (int) (a.getCurrentStock() / avgDaily);
            }

            return Map.of(
                "product_id", a.getProductId(),
                "product_name", a.getProductName(),
                "sku", a.getSku(),
                "warehouse_id", a.getWarehouseId(),
                "warehouse_name", a.getWarehouseName(),
                "current_stock", a.getCurrentStock(),
                "threshold", a.getThreshold(),
                "days_until_stockout", days,
                "supplier", Map.of(
                    "id", a.getSupplierId(),
                    "name", a.getSupplierName(),
                    "contact_email", a.getSupplierEmail()
                )
            );
        }).toList();

        return Map.of(
            "alerts", alerts,
            "total_alerts", alerts.size()
        );
    }
}
