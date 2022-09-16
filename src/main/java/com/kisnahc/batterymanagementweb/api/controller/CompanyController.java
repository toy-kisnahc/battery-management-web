package com.kisnahc.batterymanagementweb.api.controller;

import com.kisnahc.batterymanagementweb.api.dto.request.CreateCompanyRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateCompanyRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.*;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateCompanyResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteCompanyResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateCompanyResponse;
import com.kisnahc.batterymanagementweb.api.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/api/companies")
    public ApiResponse<CreateCompanyResponse> saveCompany(@RequestBody @Valid CreateCompanyRequest request) {
        return companyService.create(request);
    }

    @GetMapping("/api/companies/{companyId}")
    public ApiResponse<CompanyResponse> findCompany(@PathVariable Long companyId) {
        return companyService.get(companyId);
    }

    @GetMapping("/api/companies")
    public ApiResponse<List<CompanyResponse>> findAllByCompanies() {
        return companyService.getAll();
    }

    @PatchMapping("/api/companies/{companyId}")
    public ApiResponse<UpdateCompanyResponse> updateCompany(@PathVariable Long companyId, @RequestBody @Valid UpdateCompanyRequest request) {
        return companyService.update(companyId, request);
    }

    @DeleteMapping("/api/companies/{companyId}")
    public ApiResponse<DeleteCompanyResponse> deleteCompany(@PathVariable Long companyId) {
        return companyService.delete(companyId);
    }
}
