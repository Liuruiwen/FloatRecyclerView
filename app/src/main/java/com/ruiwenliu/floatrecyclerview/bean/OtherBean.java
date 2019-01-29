package com.ruiwenliu.floatrecyclerview.bean;

import com.ruiwenliu.floatrecyclerview.inter.MultiItemBean;
import com.ruiwenliu.floatrecyclerview.adapter.FloatAdapter;

/**
 * Created by Amuse
 * Data:2019/1/25 0025
 * Desc:列表信息
 */

public class OtherBean implements MultiItemBean {
    private int spanSize;

    public int getSpanSize() {
        return 10;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    private String name;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int getItemType() {
        return FloatAdapter.TYPE_PERSON;
    }
}
