package com.sf.rxjava.app;

import android.content.Context;

/**
 * @author shufei.li on 2016/9/1.
 */
public class Application extends android.app.Application{
    public static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }
}
