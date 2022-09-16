package com.kisnahc.batterymanagementweb.api.service;

import com.kisnahc.batterymanagementweb.api.dto.request.CreateBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.*;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateBatteryResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteBatteryResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateBatteryResponse;

import java.util.List;

public interface BatteryService {

    ApiResponse<CreateBatteryResponse> create(CreateBatteryRequest request);
    ApiResponse<BatteryResponse> get(Long batteryId);
    ApiResponse<List<BatteryResponse>> getAll();
    ApiResponse<UpdateBatteryResponse> update(Long batteryId, UpdateBatteryRequest request);
    ApiResponse<DeleteBatteryResponse> delete(Long batteryId);
}
