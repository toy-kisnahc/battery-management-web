package com.kisnahc.batterymanagementweb.api.dto.response;

import com.kisnahc.batterymanagementweb.api.domain.Sales;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteSalesResponse {

    private Long deletedSalesId;

    public DeleteSalesResponse(Sales sales) {
        this.deletedSalesId = sales.getId();
    }
}
