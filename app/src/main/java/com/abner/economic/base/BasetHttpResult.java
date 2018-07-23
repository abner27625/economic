package com.abner.economic.base;

import java.io.Serializable;

public class BasetHttpResult<T> implements Serializable {
    public int ret_code;
    public String ret_msg;
    public T data;
    public T getData(){
        return  data;
    }
}
