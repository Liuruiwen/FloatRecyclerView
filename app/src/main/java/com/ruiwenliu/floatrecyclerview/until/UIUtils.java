package com.ruiwenliu.floatrecyclerview.until;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.ruiwenliu.floatrecyclerview.MainApplication;


public class UIUtils {
    public static final int designHeight = 960;

    public static Context getContext() {
        return MainApplication.getInstance();
    }

    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */
    public static int px2dip(int px) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }




    public static View inflate(Context context, int resId) {
        return LayoutInflater.from(context).inflate(resId, null);
    }
    @Deprecated
    public static View inflate(int resId) {
        return LayoutInflater.from(getContext()).inflate(resId, null);
    }

    @Deprecated
    public static View inflate(int resId, ViewGroup parent) {
        return LayoutInflater.from(getContext()).inflate(resId, parent, false);
    }

    public static View inflate(Context context, int resId, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(resId, parent, false);
    }

    /**
     * 获取资源
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 获取文字
     */
    @Deprecated
    public static String getString(int resId) {
        return getResources().getString(resId);
    }
    /**
     * 获取文字
     */
    public static String getString(Context context, int resId) {
        return context.getResources().getString(resId);
    }

    /**
     * 获取文字数组
     */
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 获取dimen
     */
    public static int getDimens(int resId) {
        return getResources().getDimensionPixelSize(resId);
    }

    /**
     * 获取drawable
     */
    public static Drawable getDrawable(int resId) {
        return getResources().getDrawable(resId);
    }

    /**
     * 获取颜色
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 获取颜色选择器
     */
    public static ColorStateList getColorStateList(int resId) {
        return getResources().getColorStateList(resId);
    }





    /**
     * 显示软键盘
     *
     * @param text
     */
    public static void showKeyboard(EditText text) {
        InputMethodManager inputMethodManager = (InputMethodManager) text.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (!inputMethodManager.isActive()) {
            inputMethodManager.showSoftInput(text, InputMethodManager.SHOW_FORCED);
        }
    }

    /**
     * 隐藏软键盘
     *
     * @param text
     */
    public static void hideKeyboard(EditText text) {
        InputMethodManager inputMethodManager = (InputMethodManager) text.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(text.getApplicationWindowToken(), 0);
        }
    }

    public static <T extends View> T findView(View contentView, int viewId) {
        return (T) contentView.findViewById(viewId);
    }


}
