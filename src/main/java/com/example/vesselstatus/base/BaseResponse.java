package com.example.vesselstatus.base;

public class BaseResponse<T> {

    private String code;
    private T data;
    private String msg;

    public BaseResponse(){

    }

    public BaseResponse(String code){
        this.code = code;
    }

    public BaseResponse(String code, T data){
        this.code = code;
        this.data = data;
    }

    public BaseResponse(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static BaseResponse widthCode(String errorCode) {
        return new BaseResponse(errorCode);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
