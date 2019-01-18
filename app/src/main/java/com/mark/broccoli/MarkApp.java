package com.mark.broccoli;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @Desc
 * @作者 Mark
 * @时间 2019/1/18
 * @EMail 2285581945@qq.com
 */
public class MarkApp extends Application {

    public static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        //LeakCanary内存泄漏检测库初始化
        initLeakCanary();

    }

    /**
     * LeakCanary内存泄漏检测库初始化
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        sRefWatcher =  LeakCanary.install(this);
    }

    public static RefWatcher getsRefWatcher() {
        return sRefWatcher;
    }

}
