package com.kisnahc.batterymanagementweb.api.exception;

public class BatteryDuplicateException extends GlobalException{
    public BatteryDuplicateException(String message) {
        super(message);
    }
    @Override
    public int getStatusCode() {
        return 400;
    }
}
