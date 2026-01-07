package com.example.Inventory.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inventory.Service.AlertService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService service;

    @GetMapping("/{companyId}/alerts/low-stock")
    public ResponseEntity<?> alerts(@PathVariable Long companyId) {
        return ResponseEntity.ok(service.getLowStockAlerts(companyId));
    }
}
