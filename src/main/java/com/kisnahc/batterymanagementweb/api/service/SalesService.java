package com.kisnahc.batterymanagementweb.api.service;

import com.kisnahc.batterymanagementweb.api.dto.request.CreateSalesRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateOrderBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.ApiResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.SalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateSalesResponse;

import java.util.List;

public interface SalesService {

    ApiResponse<CreateSalesResponse> create(CreateSalesRequest request);

    ApiResponse<SalesResponse> get(Long salesId);

    ApiResponse<List<SalesResponse>> getAll();

    ApiResponse<UpdateSalesResponse> update(Long salesId, UpdateOrderBatteryRequest request);

    ApiResponse<DeleteSalesResponse> delete(Long salesId);
}
