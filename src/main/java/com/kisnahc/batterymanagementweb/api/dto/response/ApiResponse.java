package com.kisnahc.batterymanagementweb.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude
@Data
public class ApiResponse<T> {

    private int statusCode;
    private int count = 1;
    private T data;

    public ApiResponse(int statusCode, int count, T data) {
        this.statusCode = statusCode;
        this.count = count;
        this.data = data;
    }

    public ApiResponse(int statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }
}
