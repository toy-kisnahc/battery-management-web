package com.kisnahc.batterymanagementweb.api.dto.response;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import com.kisnahc.batterymanagementweb.api.domain.BatteryType;
import lombok.Builder;
import lombok.Data;

@Data
public class BatteryResponse {

    private Long batteryId;
    private String batteryName;
    private String batteryVoltage;
    private BatteryType batteryType;
    private int batteryQuantity;
    private int batteryPrice;

    @Builder
    public BatteryResponse(Battery battery) {
        this.batteryId = battery.getId();
        this.batteryName = battery.getName();
        this.batteryVoltage = battery.getVoltage();
        this.batteryType = battery.getType();
        this.batteryQuantity = battery.getQuantity();
        this.batteryPrice = battery.getPrice();
    }
}
