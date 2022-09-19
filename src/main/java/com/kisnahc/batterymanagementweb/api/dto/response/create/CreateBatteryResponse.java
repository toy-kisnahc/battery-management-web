package com.kisnahc.batterymanagementweb.api.dto.response.create;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import com.kisnahc.batterymanagementweb.api.domain.BatteryType;
import com.kisnahc.batterymanagementweb.api.domain.Manufacturer;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateBatteryResponse {

    private Long batteryId;
    private String batteryName;
    private String batteryVoltage;
    private BatteryType batteryType;

    private Manufacturer batteryManufacturer;
    private int batteryPrice;

    @Builder
    public CreateBatteryResponse(Battery battery) {
        this.batteryId = battery.getId();
        this.batteryName = battery.getName();
        this.batteryVoltage = battery.getVoltage();
        this.batteryType = battery.getType();
        this.batteryManufacturer = battery.getManufacturer();
        this.batteryPrice = battery.getPrice();
    }
}
