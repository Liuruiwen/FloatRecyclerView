package com.ruiwenliu.floatrecyclerview.until;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.ref.WeakReference;

/**
 * Created by Amuse
 * Data:2019/1/29 0029
 * Desc:设置状态栏透明
 */

public class StateUtils {
    private static StateUtils stateUtils;
    private WeakReference<Activity> weakReference;

    public StateUtils(Activity activity) {
        weakReference = new WeakReference<>(activity);
    }

    public static StateUtils getInstance(Activity activity) {
        if (stateUtils == null) {
            stateUtils = new StateUtils(activity);
        }
        return stateUtils;
    }

    /**
     * 启用 透明状态栏
     *
     */
    public  void setTranslucentState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = weakReference.get().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = weakReference.get().getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    public void clearActivity(){
        if(weakReference!=null){
            weakReference.clear();
            weakReference=null;
            stateUtils=null;
        }
    }

}
