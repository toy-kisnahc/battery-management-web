package com.kisnahc.batterymanagementweb.api.dto.response;

import com.kisnahc.batterymanagementweb.api.domain.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyResponse {

    private Long companyId;
    private String companyName;

    private String companyOwner;
    private String companyRegistrationNumber;
    private String companyTelNumber;

    public CompanyResponse(Company company) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.companyOwner = company.getOwner();
        this.companyRegistrationNumber = company.getCompanyRegistrationNumber();
        this.companyTelNumber = company.getTelNumber();
    }
}
