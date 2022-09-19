package com.kisnahc.batterymanagementweb.api.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

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


}
