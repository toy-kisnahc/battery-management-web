package com.kisnahc.batterymanagementweb.api.dto.response.create;

import com.kisnahc.batterymanagementweb.api.domain.Company;
import com.kisnahc.batterymanagementweb.api.domain.OrderBattery;
import com.kisnahc.batterymanagementweb.api.domain.Sales;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CreateSalesResponse {

    private Long salesId;
    private String companyName;
    private List<OrderBattery> orderBatteries;
    private int salesPrice;

    public CreateSalesResponse(Sales sales) {
        this.salesId = sales.getId();
        this.companyName = sales.getCompany().getName();
        this.orderBatteries = sales.getOrderBatteries();
        this.salesPrice = sales.getTotalPrice();
    }

}
