package com.abner.economic.network;

import android.app.Activity;
import android.os.NetworkOnMainThreadException;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.subscribers.DefaultSubscriber;

public abstract class XDNetSubscriber<T> extends DefaultSubscriber<T> {
    protected Activity activity;

    public XDNetSubscriber(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof NetworkOnMainThreadException) {
            //在主线程访问网络了
            Log.e("httperror:::", "在主线程访问网络了");
        } else if (e instanceof UnknownHostException || e instanceof ConnectException) {
//            ((BaseActivity) activity).otherPophint("请检查您的网络连接");
        } else if (e instanceof SocketTimeoutException) {
//            ((BaseActivity) activity).otherPophint("服务器请求超时");
        } else if (e instanceof HttpException) {
//            ((BaseActivity) activity).otherPophint("服务器内部错误!");
//            ((BaseActivity)activity).otherPophint("服务器错误:"+((HttpException) e).code());
        } else if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            int resultCode = apiException.resultCode;
            //不同的错误resultCode在这里处理
//            if (resultCode == 15) {
//                // TODO: 16/10/14 token失效,退出登录到首页
//                Constant.token = null;
//                Constant.userId = null;
//                SpUtils.saveData("userInfo", "");
//                Constant.mainposition = Constant.MainPostion.LOAN_POSTION;
//                ((BaseActivity) activity).otherPophint("您的账号在其他设备登录");
//                AVChatLoginUtils.logout();
//                UIUtils.executeDelay(new Runnable() {
//                    @Override
//                    public void run() {
//                        activity.startActivity(new Intent(activity, RegisterFirstActivity.class));
//                    }
//                }, 1000);
//                System.out.println(" activity:" + activity.getLocalClassName());
//            } else {
//                ((BaseActivity) activity).otherPophint(apiException.ret_msg);
//            }
        } else {
            try {
                throw e;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    @Override
    public void onComplete() {

    }
}
