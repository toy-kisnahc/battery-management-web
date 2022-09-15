package com.kisnahc.batterymanagementweb.api.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteCompanyResponse {

    private Long deletedId;
    private String deletedCompanyName;
}
