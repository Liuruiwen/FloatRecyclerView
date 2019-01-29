package com.ruiwenliu.floatrecyclerview.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ruiwenliu.floatrecyclerview.bean.AdvBean;
import com.ruiwenliu.floatrecyclerview.inter.MultiItemBean;
import com.ruiwenliu.floatrecyclerview.R;
import com.ruiwenliu.floatrecyclerview.bean.MenuBean;
import com.ruiwenliu.floatrecyclerview.bean.OtherBean;
import com.ruiwenliu.floatrecyclerview.bean.ViewBean;
import com.ruiwenliu.rxcarouselview.CarouselView;

import java.util.List;

/**
 * Created by Amuse
 * Data:2019/1/25 0025
 * Desc:多级化适配器
 */

public class FloatAdapter extends BaseMultiItemQuickAdapter<MultiItemBean, BaseViewHolder> {
    public static final int TYPE_URL = 1;//轮播
    public static final int TYPE_PERSON = 2;//菜单
    public static final int TYPE_ADV = 3;//广告
    public static final int TYPE_OTHER = 4;//列表


    public FloatAdapter(List<MultiItemBean> data) {
        super(data);
        addItemType(TYPE_URL, R.layout.item_url);
        addItemType(TYPE_ADV, R.layout.item_adv);
        addItemType(TYPE_OTHER, R.layout.item_menu);
        addItemType(TYPE_PERSON, R.layout.item_other);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemBean item) {
        switch (item.getItemType()){
            case TYPE_URL:
               if(item instanceof ViewBean){
                   CarouselView carouselView=helper.getView(R.id.carouse_view);
                   ViewBean urlBean= (ViewBean) item;
                   carouselView.setDotCarouselData(urlBean.getImageUrl(),-1,-1).startCarousel();
               }
                break;
            case TYPE_PERSON:
                if(item instanceof OtherBean){
                    TextView tvName=helper.getView(R.id.tv_name);
                    TextView tvSex=helper.getView(R.id.tv_content);
                    tvName.setText(((OtherBean) item).getName());
                    tvSex.setText(((OtherBean) item).getContent());
                }
                break;
            case TYPE_ADV:
                if(item instanceof AdvBean){
                    TextView advContent=helper.getView(R.id.tv_adv);
                    advContent.setBackgroundColor(((AdvBean) item).getAdvBgColor());
                    advContent.setText(((AdvBean) item).getAdvContent());
                }
                break;
            case TYPE_OTHER:
                if(item instanceof MenuBean){
                    ImageView ivMenu=helper.getView(R.id.iv_menu);
                    TextView textView=helper.getView(R.id.tv_content);
                    textView.setText(((MenuBean) item).getContent());
                    ivMenu.setImageResource(((MenuBean) item).getMenuImage());
                }
                break;
        }

    }

}
