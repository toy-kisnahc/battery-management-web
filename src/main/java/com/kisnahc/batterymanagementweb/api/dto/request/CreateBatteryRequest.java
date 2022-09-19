package com.kisnahc.batterymanagementweb.api.dto.request;

import com.kisnahc.batterymanagementweb.api.domain.BatteryType;
import com.kisnahc.batterymanagementweb.api.domain.Manufacturer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class CreateBatteryRequest {

    @NotBlank(message = "배터리명을 입력해 주세요.")
    private String batteryName;

    @Enumerated(EnumType.STRING)
    private BatteryType type;

    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;

    @NotBlank(message = "배터리 전압을 입력해 주세요.")
    private String voltage;

    @NotNull(message = "베터리 단가를 입력해 주세요.")
    @Min(value = 10, message = "최소 단가는 10원 부터 입력할 수 있습니다.")
    @Max(value = 100000000, message = "단가 금액은 1억원 까지 가능합니다.")
    private int price;

    public CreateBatteryRequest(String batteryName, BatteryType type, Manufacturer manufacturer, String voltage, int price) {
        this.batteryName = batteryName;
        this.type = type;
        this.manufacturer = manufacturer;
        this.voltage = voltage;
        this.price = price;
    }
}
