package com.sjy.res;

import lombok.Data;

@Data
public class ResData<T> {
    private int status;
    private String message;
    private T data;
    private String token;
    private String timestamp;


    // 获取当前时间,时间符合2024-03-04 14:12:06格式
    public ResData() {
        this.timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    public static <T> ResData<T> success(T data,String message) {
        ResData<T> resData = new ResData<>();
        resData.setStatus(ReturnCode.SUCCESS.getCode());
        resData.setMessage(message);
        resData.setData(data);
        return resData;
    }

    public static <T> ResData<T> success(T data ,String token,String message) {
        ResData<T> resData = new ResData<>();
        resData.setStatus(ReturnCode.SUCCESS.getCode());
        resData.setMessage(message);
        resData.setToken(token);
        resData.setData(data);
        return resData;
    }

    public static <T> ResData<T> success(String token,String message) {
        ResData<T> resData = new ResData<>();
        resData.setStatus(ReturnCode.SUCCESS.getCode());
        resData.setToken(token);
        resData.setMessage(message);
        return resData;
    }

    public static <T> ResData<T> success(String message) {
        ResData<T> resData = new ResData<>();
        resData.setStatus(ReturnCode.SUCCESS.getCode());
        resData.setMessage(message);
        return resData;
    }


    public static <T> ResData<T> failure(String message) {
        ResData<T> resData = new ResData<>();
        resData.setStatus(ReturnCode.FAIL.getCode());
        resData.setMessage(ReturnCode.FAIL.getMessage() + "," + message);
        return resData;
    }

}
