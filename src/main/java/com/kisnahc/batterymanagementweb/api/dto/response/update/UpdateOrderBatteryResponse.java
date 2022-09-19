package com.kisnahc.batterymanagementweb.api.dto.response.update;

import com.kisnahc.batterymanagementweb.api.domain.BatteryType;
import com.kisnahc.batterymanagementweb.api.domain.OrderBattery;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateOrderBatteryResponse {

    private Long orderId;
    private String batteryName;
    private BatteryType batteryType;
    private int orderCount;
    private int orderPrice;

    public UpdateOrderBatteryResponse(Long orderId, String batteryName, BatteryType batteryType, int orderCount, int orderPrice) {
        this.orderId = orderId;
        this.batteryName = batteryName;
        this.batteryType = batteryType;
        this.orderCount = orderCount;
        this.orderPrice = orderPrice;
    }

    public UpdateOrderBatteryResponse(OrderBattery orderBattery) {
        this.orderId = orderBattery.getId();
        this.batteryName = orderBattery.getBattery().getName();
        this.batteryType = orderBattery.getBattery().getType();
        this.orderCount = orderBattery.getOrderCount();
        this.orderPrice = orderBattery.getOrderPrice();
    }
}
