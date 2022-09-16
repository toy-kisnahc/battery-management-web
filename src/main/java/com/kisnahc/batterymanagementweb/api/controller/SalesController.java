package com.kisnahc.batterymanagementweb.api.controller;

import com.kisnahc.batterymanagementweb.api.dto.response.ApiResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.DeleteSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.SalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateSalesResponse;
import com.kisnahc.batterymanagementweb.api.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SalesController {

    private final SalesService salesService;

    @PostMapping("/api/sales")
    public ApiResponse<CreateSalesResponse> saveSales(@RequestParam Long companyId,
                                                      @RequestParam Long batteryId,
                                                      @RequestParam int count) {
        return salesService.create(companyId, batteryId, count);
    }

    @GetMapping("/api/sales")
    public ApiResponse<List<SalesResponse>> findAllSales() {
        return salesService.getAll();
    }

    @GetMapping("/api/sales/{salesId}")
    public ApiResponse<SalesResponse> findBySalesId(@PathVariable Long salesId) {
        return salesService.get(salesId);
    }

    @DeleteMapping("/api/sales/{salesId}")
    public ApiResponse<DeleteSalesResponse> deleteSales(@PathVariable Long salesId) {
        return salesService.delete(salesId);
    }
}
