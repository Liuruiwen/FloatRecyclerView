package com.ruiwenliu.floatrecyclerview.bean;

import com.ruiwenliu.floatrecyclerview.inter.MultiItemBean;
import com.ruiwenliu.floatrecyclerview.adapter.FloatAdapter;

/**
 * Created by Amuse
 * Data:2019/1/25 0025
 * Desc:菜单
 */

public class MenuBean implements MultiItemBean {
    private int spanSize;

    public int getSpanSize() {
        return 2;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    private String content;
    private int menuImage;

    public int getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(int menuImage) {
        this.menuImage = menuImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return FloatAdapter.TYPE_OTHER;
    }
}
