package com.ruiwenliu.floatrecyclerview;

import android.app.Application;

/**
 * Created by Amuse
 * Data:2019/1/27 0027
 * Desc:
 */

public class MainApplication extends Application{
    private static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance=this;
    }
    public static Application getInstance() {
        return instance;
    }

}
