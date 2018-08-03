package com.abner.economic;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;

import com.abner.economic.utils.UIUtils;
import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.header.StoreHouseHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
//import android.support.multidex.MultiDex;

public class MyApplication extends Application {
    private static MyApplication myApplication;
    private static Handler handler;
    private static int mainThreadTid;

    static{
        //防止内存泄漏
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                StoreHouseHeader storeHouseHeader = new StoreHouseHeader(context);
                storeHouseHeader.initWithString("lonny song");
                storeHouseHeader.setTextColor(Color.rgb(238,199,16));
                storeHouseHeader.setBackgroundColor(UIUtils.getColor(R.color.color_008dfe));
                return storeHouseHeader;
            }
        });
    }
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        handler = new Handler();
        mainThreadTid = android.os.Process.myTid();

        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init( this );
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    public static MyApplication getMyapplication(){
        return myApplication;
    }
    public static Handler getHandler() {
        return handler;
    }
    public static int getMainThreadId() {
        return mainThreadTid;
    }
    public String getVersionName() {
        String code="";
        PackageManager pm = getApplicationContext().getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(getApplicationContext().getPackageName(), 0);
            code = info.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }
}
