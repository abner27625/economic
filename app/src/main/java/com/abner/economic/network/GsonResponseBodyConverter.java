package com.abner.economic.network;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type adapter;

    GsonResponseBodyConverter(Gson gson, Type adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            Log.d("Network", "response>>" + response);
            //ResultResponse 只解析result字段
            ResultResponse resultResponse = gson.fromJson(response, ResultResponse.class);
            if (resultResponse.ret_code ==1) {
                //result==0表示成功返回，继续用本来的Model类解析
                return gson.fromJson(response, adapter);
            } else {
                //ErrResponse 将msg解析为异常消息文本
                throw new ApiException(resultResponse.ret_code, resultResponse.ret_msg);
            }
        }catch (JsonParseException e){
            e.printStackTrace();
//            throw new ApiException(Common.formatErrorCode, Common.formatErrorTip);
            throw new ApiException(0,"");
        }finally {
            value.close();
        }
    }
}