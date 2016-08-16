package com.see.demoone;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by see on 2016/8/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);//初始化Fresco
    }
}
