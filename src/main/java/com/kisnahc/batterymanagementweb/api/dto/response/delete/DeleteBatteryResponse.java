package com.kisnahc.batterymanagementweb.api.dto.response.delete;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteBatteryResponse {

    private Long deletedId;
    private String deletedBatteryName;

    public DeleteBatteryResponse(Battery battery) {
        this.deletedId = battery.getId();
        this.deletedBatteryName = battery.getName();
    }
}
