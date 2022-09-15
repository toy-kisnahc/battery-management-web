package com.kisnahc.batterymanagementweb.api.dto.response;

import com.kisnahc.batterymanagementweb.api.domain.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyResponse {

    private Long companyId;
    private String companyName;

    public CompanyResponse(Company company) {
        this.companyId = company.getId();
        this.companyName = company.getName();
    }
}
