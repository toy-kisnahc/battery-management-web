package com.kisnahc.batterymanagementweb.api.exception;

public class BatteryNotFoundException extends GlobalException{

    private static final String MESSAGE = "배터리를 찾을 수 없습니다.";
    public BatteryNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
