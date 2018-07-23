package com.abner.economic.base;

import java.io.Serializable;

public class HttpResult<T> implements Serializable {

    public int ret_code;
    public String ret_msg;
    public T data;

    @Override
    public String toString() {
        return "HttpResult{" +
                "ret_code=" + ret_code +
                ", ret_msg='" + ret_msg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
