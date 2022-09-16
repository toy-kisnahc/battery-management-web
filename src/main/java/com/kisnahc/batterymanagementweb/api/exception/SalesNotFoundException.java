package com.kisnahc.batterymanagementweb.api.exception;

public class SalesNotFoundException extends GlobalException {

    private static final String MESSAGE = "매출 정보를 찾을 수 없습니다.";

    public SalesNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
