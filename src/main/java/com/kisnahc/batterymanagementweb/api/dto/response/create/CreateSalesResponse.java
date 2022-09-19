package com.kisnahc.batterymanagementweb.api.dto.response.create;

import com.kisnahc.batterymanagementweb.api.domain.OrderBattery;
import com.kisnahc.batterymanagementweb.api.domain.Sales;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class CreateSalesResponse {

    private Long salesId;
    private String companyName;
    private List<OrderBattery> orderBatteries;

    private LocalDate salesDate;
    private int salesPrice;

    public CreateSalesResponse(Sales sales) {
        this.salesId = sales.getId();
        this.companyName = sales.getCompany().getName();
        this.orderBatteries = sales.getOrderBatteries();
        this.salesDate = sales.getSalesDate();
        this.salesPrice = sales.getTotalPrice();
    }

}
