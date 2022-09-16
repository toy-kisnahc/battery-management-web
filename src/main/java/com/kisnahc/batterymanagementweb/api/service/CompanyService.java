package com.kisnahc.batterymanagementweb.api.service;

import com.kisnahc.batterymanagementweb.api.dto.request.CreateCompanyRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateCompanyRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.*;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateCompanyResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteCompanyResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateCompanyResponse;

import java.util.List;

public interface CompanyService {

    ApiResponse<CreateCompanyResponse> create(CreateCompanyRequest request);
    ApiResponse<CompanyResponse> get(Long companyId);
    ApiResponse<List<CompanyResponse>> getAll();
    ApiResponse<UpdateCompanyResponse> update(Long companyId, UpdateCompanyRequest request);
    ApiResponse<DeleteCompanyResponse> delete(Long companyId);
}
