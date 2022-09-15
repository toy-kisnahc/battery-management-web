package com.kisnahc.batterymanagementweb.api.exception;

public class CompanyNotFoundException extends GlobalException{
    private static final String MESSAGE = "회사를 찾을 수 없습니다.";
    public CompanyNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
