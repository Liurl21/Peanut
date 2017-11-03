package com.liurl.peanut;

import android.app.Application;
import android.content.Context;

import com.liurl.peanut.utils.DaoUtil;

/**
 * @author liuruilin
 * @data 2017/10/27
 * @describe
 */
public class PeanutApplication extends Application {
    public static Context globalContext;

    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = getApplicationContext();
        DaoUtil.INSTANCE.initDataBase(globalContext);
    }
}
