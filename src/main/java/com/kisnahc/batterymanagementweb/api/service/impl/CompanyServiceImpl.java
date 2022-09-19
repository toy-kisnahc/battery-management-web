package com.kisnahc.batterymanagementweb.api.service.impl;

import com.kisnahc.batterymanagementweb.api.domain.Company;
import com.kisnahc.batterymanagementweb.api.dto.request.CreateCompanyRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateCompanyRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.*;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateCompanyResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteCompanyResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateCompanyResponse;
import com.kisnahc.batterymanagementweb.api.exception.CompanyDuplicateException;
import com.kisnahc.batterymanagementweb.api.exception.CompanyNotFoundException;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.CompanyRepository;
import com.kisnahc.batterymanagementweb.api.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static javax.servlet.http.HttpServletResponse.SC_CREATED;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    /**
     * 매출처 등록.
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ApiResponse<CreateCompanyResponse> create(CreateCompanyRequest request) {

        Company company = Company.builder()
                .name(request.getCompanyName())
                .owner(request.getCompanyOwner())
                .companyRegistrationNumber(request.getCompanyRegistrationNumber())
                .telNumber(request.getTelNumber())
                .build();

        duplicateValidate(company.getCompanyRegistrationNumber(), company.getTelNumber());

        Company saveCompany = companyRepository.save(company);

        return new ApiResponse<>(SC_CREATED, new CreateCompanyResponse(saveCompany));
    }

    /**
     * 매출처 조회.
     * @param companyId
     * @return
     */
    @Override
    public ApiResponse<CompanyResponse> get(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);
        return new ApiResponse<>(SC_OK, new CompanyResponse(company));
    }

    /**
     * 매출처 전체 조회.
     * @return
     */
    @Override
    public ApiResponse<List<CompanyResponse>> getAll() {
        List<Company> companies = companyRepository.findAll();

        List<CompanyResponse> companyResponses = companies.stream()
                .map(CompanyResponse::new)
                .collect(Collectors.toList());

        return new ApiResponse<>(SC_OK, companyResponses.size(), companyResponses);
    }

    /**
     * 매출처 수정.
     * @param companyId
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ApiResponse<UpdateCompanyResponse> update(Long companyId, UpdateCompanyRequest request) {
        Company company = companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);

        company.updateCompany(request);

        return new ApiResponse<>(SC_OK, new UpdateCompanyResponse(company));
    }

    /**
     * 매출처 삭제.
     * @param companyId
     * @return
     */
    @Transactional
    @Override
    public ApiResponse<DeleteCompanyResponse> delete(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);

        companyRepository.delete(company);

        return new ApiResponse<>(SC_OK, new DeleteCompanyResponse(company));
    }

    private void duplicateValidate(String companyRegistrationNumber, String telNumber) {
        if (companyRepository.existsByCompanyRegistrationNumber(companyRegistrationNumber)) {
            throw new CompanyDuplicateException("이미 등록된 사업자등록번호 입니다.");
        }
        if (companyRepository.existsByTelNumber(telNumber)) {
            throw new CompanyDuplicateException("이미 등록된 전화번호 입니다.");
        }
    }
}
