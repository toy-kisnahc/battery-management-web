package com.kisnahc.batterymanagementweb.api.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
public class CreateSalesRequest {

    @NonNull
    private Long companyId;
    @NonNull
    private Long batteryId;
    @NonNull
    private int count;

    public CreateSalesRequest(Long companyId, Long batteryId, int count) {
        this.companyId = companyId;
        this.batteryId = batteryId;
        this.count = count;
    }
}
