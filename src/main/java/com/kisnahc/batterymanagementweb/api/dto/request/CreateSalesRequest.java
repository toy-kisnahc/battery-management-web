package com.kisnahc.batterymanagementweb.api.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class CreateSalesRequest {

    @NonNull
    private Long companyId;
    @NonNull
    private Long batteryId;

    @NonNull
    private LocalDate salesDate;
    @NonNull
    private int count;

    public CreateSalesRequest(@NonNull Long companyId, @NonNull Long batteryId, LocalDate salesDate, @NonNull int count) {
        this.companyId = companyId;
        this.batteryId = batteryId;
        this.salesDate = salesDate;
        this.count = count;
    }

}
