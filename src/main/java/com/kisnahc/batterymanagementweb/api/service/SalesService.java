package com.kisnahc.batterymanagementweb.api.service;

import com.kisnahc.batterymanagementweb.api.dto.response.ApiResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.DeleteSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.SalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateSalesResponse;

import java.util.List;

public interface SalesService {

    ApiResponse<CreateSalesResponse> create(Long companyId, Long batteryId, int count);

    ApiResponse<SalesResponse> get(Long salesId);

    ApiResponse<List<SalesResponse>> getAll();

    ApiResponse<?> update(Long salesId);

    ApiResponse<DeleteSalesResponse> delete(Long salesId);
}
