package com.example.Inventory.Dtos;


public interface LowStockAlertProjection {

    Long getProductId();
    String getProductName();
    String getSku();

    Long getWarehouseId();
    String getWarehouseName();

    Integer getCurrentStock();
    Integer getThreshold();

    Long getSupplierId();
    String getSupplierName();
    String getSupplierEmail();

    Long getTotalSoldLast30Days();
}

