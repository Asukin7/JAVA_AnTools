package com.anTools.common;

public enum ResultStatus {

    SUCCESS(0, "Success"),
    UNKNOWN_ERROR(1, "Unknown error");

    private final Integer code;
    private final String message;

    ResultStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResultStatus{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
