package com.six.animationplay.application;

import android.app.Application;

/**
 * Created by Administrator on 2017/3/28.
 */

public class AnimationApplication extends Application {

    private static AnimationApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AnimationApplication getInstance() {
        return instance;
    }
}
