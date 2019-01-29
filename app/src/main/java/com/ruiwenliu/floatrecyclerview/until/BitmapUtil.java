package com.ruiwenliu.floatrecyclerview.until;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import static com.ruiwenliu.floatrecyclerview.until.UIUtils.getResources;

/**
 * Created by Amuse
 * Data:2019/1/27 0027
 * Desc:图片管理类
 */

public class BitmapUtil {
    private static BitmapUtil bitmapUtil;
    public static BitmapUtil getInstance() {
        if (bitmapUtil == null) {
            bitmapUtil = new BitmapUtil();
        }
        return bitmapUtil;
    }
    /**
     * 将图片资源转为BitmapDrawable
     *
     * @param imageID
     * @return
     */
    public BitmapDrawable createBitmapDrawable(int imageID) {
        InputStream is = null;
        try {
//            Log.d(Utils.TAG, "Begin createBitmapDrawable");
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inPreferredConfig = Bitmap.Config.RGB_565;
            opt.inPurgeable = true;
            opt.inInputShareable = true;
            is = getResources().openRawResource(imageID);
            //decodeStream直接调用JNI>>nativeDecodeAsset()来完成decode，无需再使用java层的createBitmap，节省了java层的空间
            Bitmap bm = BitmapFactory.decodeStream(is, null, opt);
            BitmapDrawable bd = new BitmapDrawable(getResources(), bm);
//            Log.d(Utils.TAG, "finish createBitmapDrawable---BitmapDrawable " + bd==null?"==null":"!=null");
            return bd;
        } finally {
            try {
                if (is != null) {
                    is.close();
                    is = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
