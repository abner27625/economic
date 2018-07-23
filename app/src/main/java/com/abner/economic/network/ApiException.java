package com.abner.economic.network;

public class ApiException extends RuntimeException {
    public int resultCode;
    public String ret_msg;
    public ApiException(int resultCode, String ret_msg) {
        super(ret_msg);
        this.resultCode = resultCode;
        this.ret_msg=ret_msg;
    }
}
