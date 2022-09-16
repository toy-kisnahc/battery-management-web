package com.kisnahc.batterymanagementweb.api.controller;

import com.kisnahc.batterymanagementweb.api.dto.request.CreateBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.*;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateBatteryResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteBatteryResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateBatteryResponse;
import com.kisnahc.batterymanagementweb.api.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BatteryController {

    private final BatteryService batteryService;

    @PostMapping("/api/batteries")
    public ApiResponse<CreateBatteryResponse> saveBattery(@RequestBody @Valid CreateBatteryRequest request) {
        return batteryService.create(request);
    }

    @GetMapping("/api/batteries/{batteryId}")
    public ApiResponse<BatteryResponse> findBattery(@PathVariable Long batteryId) {
        return batteryService.get(batteryId);
    }

    @GetMapping("/api/batteries")
    public ApiResponse<List<BatteryResponse>> findAllByBatteries() {
        return batteryService.getAll();
    }

    @PutMapping("/api/batteries/{batteryId}")
    public ApiResponse<UpdateBatteryResponse> updateBattery(@PathVariable Long batteryId, @RequestBody @Valid UpdateBatteryRequest request) {
        return batteryService.update(batteryId, request);
    }

    @DeleteMapping("/api/batteries/{batteryId}")
    public ApiResponse<DeleteBatteryResponse> deleteBattery(@PathVariable Long batteryId) {
        return batteryService.delete(batteryId);
    }
}
