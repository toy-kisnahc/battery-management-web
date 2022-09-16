package com.kisnahc.batterymanagementweb.api.dto.response.update;

import com.kisnahc.batterymanagementweb.api.domain.Company;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class UpdateCompanyResponse {

    private Long companyId;
    private String companyName;
    private String updatedCompanyRegistrationNumber;
    private String updateTelNumber;

    public UpdateCompanyResponse(Company company) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.updatedCompanyRegistrationNumber = company.getCompanyRegistrationNumber();
        this.updateTelNumber  = company.getTelNumber();
    }
}
