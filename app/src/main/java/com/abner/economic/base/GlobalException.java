package com.abner.economic.base;

import android.content.Context;
import android.util.Log;

import java.lang.Thread.UncaughtExceptionHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 * @author user
 */
public class GlobalException implements UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler";
    //CrashHandler实例
    private static GlobalException INSTANCE = new GlobalException();
    //系统默认的UncaughtException处理类
    private UncaughtExceptionHandler mDefaultHandler;
    //程序的Context对象
    private Context mContext;
    //用来存储设备信息和异常信息
    private Map<String, String> infos = new HashMap<String, String>();

    //用于格式化日期,作为日志文件名的一部分
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    /**
     * 保证只有一个CrashHandler实例
     */
    private GlobalException() {
    }

    /**
     * 获取CrashHandler实例 ,单例模式
     */
    public static GlobalException getInstance() {
        return INSTANCE;
    }

    /**
     * 初始化
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
//        System.out.println(ex.getMessage());
        Log.e("loony","异常信息"+ex.getLocalizedMessage());
        Log.e("loony","异常信息"+ex.getMessage());
        Log.e("loony","异常信息"+ex.toString());
        if (mDefaultHandler != null) {
//            MobclickAgent.reportError(mContext, ex);
        }
//        MobclickAgent.onKillProcess(mContext);
        //退出程序
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}
