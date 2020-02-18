package com.anTools.common;

public enum ResultStatus {

    SUCCESS(0, "Success"),
    UNKNOWN_ERROR(1, "Unknown error"),
    NO_TOKEN(2, "No token"),
    UNAUTHORIZED(3, "Unauthorized"),
    LOGIN_FAIL(101, "Login fail"),
    LOGIN_EXPIRE(101, "Login expire"),
    USER_INSERT_FAIL(201, "User data insert fail"),
    USER_UPDATE_FAIL(202, "User data update fail");

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
