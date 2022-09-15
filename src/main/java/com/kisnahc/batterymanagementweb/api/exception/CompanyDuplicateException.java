package com.kisnahc.batterymanagementweb.api.exception;

public class CompanyDuplicateException extends GlobalException {
    public CompanyDuplicateException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
