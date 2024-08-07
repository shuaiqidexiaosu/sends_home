package com.sjy.res;


import lombok.Getter;

@Getter
public enum ReturnCode {
    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    NOT_FOUND(404, "未找到");

    private final int code;

    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }



}
