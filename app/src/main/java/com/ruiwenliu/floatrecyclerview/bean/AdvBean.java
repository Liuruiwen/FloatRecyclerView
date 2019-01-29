package com.ruiwenliu.floatrecyclerview.bean;

import com.ruiwenliu.floatrecyclerview.adapter.FloatAdapter;
import com.ruiwenliu.floatrecyclerview.inter.MultiItemBean;

/**
 * Created by Amuse
 * Data:2019/1/29 0029
 * Desc:广告
 */

public class AdvBean  implements MultiItemBean {

    private int advBgColor;
    private String advContent;

    public int getAdvBgColor() {
        return advBgColor;
    }

    public void setAdvBgColor(int advBgColor) {
        this.advBgColor = advBgColor;
    }

    public String getAdvContent() {
        return advContent;
    }

    public void setAdvContent(String advContent) {
        this.advContent = advContent;
    }

    @Override
    public int getSpanSize() {
        return 5;
    }

    @Override
    public int getItemType() {
        return FloatAdapter.TYPE_ADV;
    }
}
