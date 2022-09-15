package com.kisnahc.batterymanagementweb.api.dto.response;

import com.kisnahc.batterymanagementweb.api.domain.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteCompanyResponse {

    private Long deletedId;
    private String deletedCompanyName;

    public DeleteCompanyResponse(Company company) {
        this.deletedId = company.getId();
        this.deletedCompanyName = company.getName();
    }
}
