package com.ruiwenliu.floatrecyclerview.bean;

import android.widget.ImageView;

import com.ruiwenliu.floatrecyclerview.inter.MultiItemBean;
import com.ruiwenliu.floatrecyclerview.adapter.FloatAdapter;

import java.util.List;

/**
 * Created by Amuse
 * Data:2019/1/25 0025
 * Desc:轮播
 */

public class ViewBean implements MultiItemBean {
    private int spanSize;

    public int getSpanSize() {
        return 10;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    private List<ImageView> imageList;

    public List<ImageView> getImageUrl() {
        return imageList;
    }

    public void setImageUrl(List<ImageView> imageUrl) {
        this.imageList = imageUrl;
    }

    @Override
    public int getItemType() {
        return FloatAdapter.TYPE_URL;
    }
}
