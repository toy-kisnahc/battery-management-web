package com.kisnahc.batterymanagementweb.api.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class UpdateOrderBatteryRequest {

    @NotNull(message = "주문 번호를 입력해 주세요.")
    private Long orderBatteryId;

    @NotNull(message = "주문 수량을 입력해 주세요.")
    @Min(value = 1, message = "수량 변경은 최소 1개 이상부터 가능합니다.")
    @Max(value = 1000, message = "수량 등록은 최대 1000개까지 가능합니다.")
    private int orderCount;

}
