package com.abner.economic.network;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class Network {
    private Retrofit retrofit;
    private XDApi xdApi;
    BasicParamsInterceptor basicParamsInterceptor;
//    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(this::showRetrofitLog);

    private Network() {
        basicParamsInterceptor = new BasicParamsInterceptor.Builder()
                .addParam("equipmentIdentifying", "")
                .addParam("clientVersion", "" )
                .addParam("loginPathway", "1")
                .addParam("loginTerminal", "2")
//                .addParam("userId", TextUtils.isEmpty(Common.getUserInfo().userId) ? "" : Common.getUserInfo().userId)
//                .addParam("tokenCode", TextUtils.isEmpty(Common.getUserInfo().tokenCode) ? "" : Common.getUserInfo().tokenCode)
                .build();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        retrofit = new Retrofit.Builder()
                .client(new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).addInterceptor(basicParamsInterceptor).build())
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        xdApi = retrofit.create(XDApi.class);
    }

    private static class SingletonHolder {
        private static final Network INSTANCE = new Network();
    }

    public static Network getInstance() {
//        if (Common.getUserInfo().tokenCode != null) {
//            SingletonHolder.INSTANCE.basicParamsInterceptor.paramsMap.put("tokenCode", Common.getUserInfo().tokenCode);
//        }
//        if (Common.getUserInfo().userId != null) {
//            SingletonHolder.INSTANCE.basicParamsInterceptor.paramsMap.put("userId", Common.getUserInfo().userId);
//        }
//        if (Constant.deviceID != null) {
//            SingletonHolder.INSTANCE.basicParamsInterceptor.paramsMap.put("equipmentIdentifying", Constant.deviceID);
//        }
        return SingletonHolder.INSTANCE;
    }


//    public static Flowable<WodeInfo> okHttpUpload(String partUrl, String filePath, Callback callback) {
//        File file = new File(filePath);             // 需要上传的文件
//        RequestBody requestFile =               // 根据文件格式封装文件
//                RequestBody.create(MediaType.parse("application/octet-stream"), file);
//
//        // 初始化请求体对象，设置Content-Type以及文件数据流
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)            // multipart/form-data
//                .addFormDataPart("inputStream", file.getName(), requestFile)
//                .addFormDataPart("fileName",file.getName())
//                .addFormDataPart("",Common.getUserInfo().)
//                .build();
//        // 封装OkHttp请求对象，初始化请求参数
//        Request request = new Request.Builder()
//                .url(Common.getCommonUrl() + partUrl)                // 上传url地址
//                .post(requestBody)              // post请求体
//                .build();
//
//        final okhttp3.OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
//        OkHttpClient okHttpClient = httpBuilder
//                .connectTimeout(100, TimeUnit.SECONDS)          // 设置请求超时时间
//                .writeTimeout(150, TimeUnit.SECONDS)
//                .build();
//        // 发起异步网络请求
//        okHttpClient.newCall(request).enqueue(callback);
//    }

}
