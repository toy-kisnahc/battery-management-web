package com.kisnahc.batterymanagementweb.api.dto.response;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateBatteryResponse {

    private Long id;
    private int updatedQuantity;
    private int updatedPrice;

    public UpdateBatteryResponse(Battery battery) {
        this.id = battery.getId();
        this.updatedQuantity = battery.getQuantity();
        this.updatedPrice = battery.getPrice();
    }
}
