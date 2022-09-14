package com.kisnahc.batterymanagementweb.api.dto.request;

import com.kisnahc.batterymanagementweb.api.domain.BatteryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

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
    private String name;

    @Enumerated(EnumType.STRING)
    private BatteryType type;

    @NotBlank(message = "배터리 전압을 입력해 주세요.")
    private String voltage;

    @NotNull(message = "배터리 수량을 입력해 주세요.")
    @Min(value = 1, message = "수량 등록은 1개 부터 가능합니다.")
    @Max(value = 10000, message = "최대 등록 수량은 10000개 입니다.")
    private int quantity;

    @NotNull(message = "베터리 단가를 입력해 주세요.")
    @Min(value = 10, message = "최소 단가는 10원 부터 입력할 수 있습니다.")
    @Max(value = 100000000, message = "단가 금액은 1억원 까지 가능합니다.")
    private int price;

    public CreateBatteryRequest(String name, BatteryType type, String voltage, int quantity, int price) {
        this.name = name;
        this.type = type;
        this.voltage = voltage;
        this.quantity = quantity;
        this.price = price;
    }
}
