package com.welot.newsdemomd.app;

import android.app.Application;
import android.content.Context;

import com.apkfuns.logutils.LogUtils;
import com.welot.newsdemomd.common.CrashHandler;
import im.fir.sdk.FIR;
public class MyApp extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initUtil();
    }

    private void initUtil() {

        FIR.init(this);
        //捕获程序异常信息
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

        LogUtils.configAllowLog = true;
       // LogUtils.configTagPrefix = "lnyp-";

    }
}
