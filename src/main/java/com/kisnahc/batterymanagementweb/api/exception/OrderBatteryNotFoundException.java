package com.kisnahc.batterymanagementweb.api.exception;

public class OrderBatteryNotFoundException extends GlobalException{

    private static final String MESSAGE = "배터리 주문 정보를 찾을 수 없습니다.";
    public OrderBatteryNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
