package com.kisnahc.batterymanagementweb.api.dto.response.update;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import com.kisnahc.batterymanagementweb.api.domain.BatteryType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateBatteryResponse {

    private Long id;

    private String updatedBatteryName;

    private BatteryType updatedBatteryType;
    private String updatedVoltage;
    private int updatedPrice;

    public UpdateBatteryResponse(Battery battery) {
        this.id = battery.getId();
        this.updatedBatteryName = battery.getName();
        this.updatedBatteryType = battery.getType();
        this.updatedVoltage = battery.getVoltage();
        this.updatedPrice = battery.getPrice();
    }
}
