package com.kisnahc.batterymanagementweb.api.controller;

import com.kisnahc.batterymanagementweb.api.dto.request.CreateSalesRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateOrderBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.ApiResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.SalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateSalesResponse;
import com.kisnahc.batterymanagementweb.api.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SalesController {

    private final SalesService salesService;

    @PostMapping("/api/sales")
    public ApiResponse<CreateSalesResponse> saveSales(@RequestBody @Valid CreateSalesRequest request) {
        return salesService.create(request);
    }

    @GetMapping("/api/sales")
    public ApiResponse<List<SalesResponse>> findAllSales() {
        return salesService.getAll();
    }

    @GetMapping("/api/sales/{salesId}")
    public ApiResponse<SalesResponse> findBySalesId(@PathVariable Long salesId) {
        return salesService.get(salesId);
    }

    @PatchMapping("/api/sales/{salesId}")
    public ApiResponse<UpdateSalesResponse> updateSales(@PathVariable Long salesId,
                                                        @RequestBody @Valid UpdateOrderBatteryRequest request) {
        return salesService.update(salesId, request);
    }

    @DeleteMapping("/api/sales/{salesId}")
    public ApiResponse<DeleteSalesResponse> deleteSales(@PathVariable Long salesId) {
        return salesService.delete(salesId);
    }

}
