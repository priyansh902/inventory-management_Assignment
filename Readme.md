# StockFlow – Inventory Management System (B2B SaaS)

StockFlow is a backend inventory management system designed for B2B SaaS use cases.  
It allows companies to manage products across multiple warehouses, track inventory levels, record sales activity, and generate low-stock alerts with supplier information.

This project was implemented as part of a backend case study focusing on system design, database modeling, and API development using Spring Boot.

---

## Tech Stack

- Java 20
- Spring Boot 4
- Spring Data JPA
- Hibernate 7
- MySQL 8
- Lombok
- RESTful APIs

---

## Key Features

- Multi-company support
- Multiple warehouses per company
- Products stored across multiple warehouses
- Inventory tracking with quantity per warehouse
- Sales history tracking
- Supplier management (many-to-many with products)
- Low-stock alert system based on:
  - Product-specific thresholds
  - Recent sales activity
  - Current inventory levels
- Clean separation of controller, service, repository layers

---

## Database Design Overview

### Core Tables
- `companies`
- `warehouses`
- `products`
- `inventory`
- `sales`
- `suppliers`
- `product_supplier` (many-to-many mapping)

### Important Constraints
- SKU is unique across the platform
- `(product_id, warehouse_id)` is unique in inventory
- Inventory is separated from product to support multi-warehouse storage
- Sales data enables future forecasting and alert calculations

---

## API Endpoints

### Low Stock Alerts

