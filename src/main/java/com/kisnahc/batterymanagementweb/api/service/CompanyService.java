package com.kisnahc.batterymanagementweb.api.service;

import com.kisnahc.batterymanagementweb.api.dto.request.CreateCompanyRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateCompanyRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.ApiResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.CompanyResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.CreateCompanyResponse;

import java.util.List;

public interface CompanyService {

    ApiResponse<CreateCompanyResponse> create(CreateCompanyRequest request);
    ApiResponse<CompanyResponse> get(Long companyId);
    ApiResponse<List<CompanyResponse>> getAll();
    ApiResponse<?> update(Long companyId, UpdateCompanyRequest request);
    ApiResponse<?> delete(Long companyId);
}
