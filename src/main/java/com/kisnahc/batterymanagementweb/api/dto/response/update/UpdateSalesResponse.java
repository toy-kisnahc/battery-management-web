package com.kisnahc.batterymanagementweb.api.dto.response.update;

import com.kisnahc.batterymanagementweb.api.domain.OrderBattery;
import com.kisnahc.batterymanagementweb.api.domain.Sales;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateOrderBatteryRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class UpdateSalesResponse {

    private Long salesId;
    private String companyName;
    private List<UpdateOrderBatteryResponse> orderBatteries;
    private int salesPrice;

    public UpdateSalesResponse(Sales sales) {
        this.salesId = sales.getId();
        this.companyName = sales.getCompany().getName();
        this.orderBatteries = sales.getOrderBatteries().stream()
                .map(UpdateOrderBatteryResponse::new)
                .collect(Collectors.toList());
        this.salesPrice = sales.getTotalPrice();
    }
}
