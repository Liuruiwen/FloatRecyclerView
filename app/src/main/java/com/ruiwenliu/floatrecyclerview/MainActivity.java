package com.ruiwenliu.floatrecyclerview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ruiwenliu.floatrecyclerview.adapter.FloatAdapter;
import com.ruiwenliu.floatrecyclerview.bean.AdvBean;
import com.ruiwenliu.floatrecyclerview.bean.MenuBean;
import com.ruiwenliu.floatrecyclerview.bean.OtherBean;
import com.ruiwenliu.floatrecyclerview.bean.ViewBean;
import com.ruiwenliu.floatrecyclerview.inter.MultiItemBean;
import com.ruiwenliu.floatrecyclerview.until.StateUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRv;
    private TextView tvTest;
    private LinearLayout layHeader;
    private int mDistanceY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StateUtils.getInstance(this).setTranslucentState();
        setContentView(R.layout.activity_main);
        tvTest = findViewById(R.id.tv_test);
        layHeader = findViewById(R.id.lay_head);
        final List<MultiItemBean> list = getList();
        FloatAdapter floatAdapter = new FloatAdapter(list);
        mainRv = findViewById(R.id.main_rv);
        mainRv.setLayoutManager(new GridLayoutManager(this, 10));
        /**
         * 设置每个Item的横排显示数量
         *  注意：======对应GridLayoutManager设置
         */
        floatAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return list.get(position).getSpanSize();
            }
        });
        mainRv.setAdapter(floatAdapter);
        mainRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                int toolbarHeight = tvTest.getBottom();

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    layHeader.setBackgroundColor(Color.argb((int) alpha, 150, 0, 0));
                    tvTest.setTextColor(Color.argb((int) alpha, 0, 0, 0));
                } else {
                    //上述虽然判断了滑动距离与toolbar高度相等的情况，但是实际测试时发现，标题栏的背景色
                    //很少能达到完全不透明的情况，所以这里又判断了滑动距离大于toolbar高度的情况，
                    //将标题栏的颜色设置为完全不透明状态
                    layHeader.setBackgroundResource(R.color.colorPrimary);
                    tvTest.setTextColor(Color.WHITE);
                }

            }
        });


    }


    /**
     * 获取集合数据
     *
     * @return
     */
    private List<MultiItemBean> getList() {
        List<MultiItemBean> listMulti = new ArrayList<>();
        //添加轮播数据
        ViewBean urlBean = new ViewBean();
        urlBean.setImageUrl(getListImage());

        //添加菜单数据
        int[] imageGroup = {R.drawable.menu_pig_one, R.drawable.menu_pig_two, R.drawable.menu_pig_three, R.drawable.menu_pig_four, R.drawable.menu_pig_five, R.drawable.menu_pig_six
                , R.drawable.menu_pig_seven, R.drawable.menu_pig_eight, R.drawable.menu_pig_nine, R.drawable.menu_pig_ten};
        listMulti.add(urlBean);
        for (int i = 0; i < imageGroup.length; i++) {
            MenuBean otherBean = new MenuBean();
            otherBean.setContent("小姐姐" + i);
            otherBean.setMenuImage(imageGroup[i]);
            listMulti.add(otherBean);
        }
        //添加广告
        for (int i = 0; i < 4; i++) {
            AdvBean otherBean = new AdvBean();
            int color = 0;
            switch (i) {
                case 0:
                    color = Color.BLACK;
                    break;
                case 1:
                    color = Color.RED;
                    break;
                case 2:
                    color = Color.BLUE;
                    break;
                case 3:
                    color = Color.YELLOW;
                    break;
            }
            otherBean.setAdvBgColor(color);
            otherBean.setAdvContent("猪猪广告" + i);
            listMulti.add(otherBean);
        }

        //添加其它数据
        for (int i = 0; i < 50; i++) {
            OtherBean otherBean = new OtherBean();
            otherBean.setName("猪猪侠" + i);
            otherBean.setContent("农历己亥猪年从2019年2月5日开始，到2020年1月24日结束，也是一个平年，共有354天。" + i);
            listMulti.add(otherBean);
        }

        return listMulti;
    }


    /**
     * 获取轮播View数据
     *
     * @return
     */
    private List<ImageView> getListImage() {
        List<ImageView> list = new ArrayList<>();
        list.add(setDataToPhotoView("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534824807829&di=9ef4df042cb2bfc1a42e9243801baefa&imgtype=0&src=http%3A%2F%2Fimg4.cache.netease.com%2Fphoto%2F0026%2F2014-07-29%2FA2A3C8SK513O0026.jpg"));
        list.add(setDataToPhotoView("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534824807828&di=36ee950c0e97a030ac828f9715a15b68&imgtype=0&src=http%3A%2F%2Fimage14.m1905.cn%2Fuploadfile%2F2016%2F0822%2F20160822042056894099_watermark.jpg"));
        list.add(setDataToPhotoView("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534824807828&di=01c25d775b1e973e7dc056cd66776806&imgtype=0&src=http%3A%2F%2Fpic.eastlady.cn%2Fuploads%2Ftp%2F201605%2F10%2F31.jpg"));
        return list;
    }


    /**
     * 临时设置 可以写成公共方法
     *
     * @param url 地址这些数据应该是后台传给你的，这里只是做标识用
     * @return
     */
    private ImageView setDataToPhotoView(String url) {
        ImageView imageView = (ImageView) LayoutInflater.from(this).inflate(R.layout.item_image, null);
        Glide.with(this).load(url).into(imageView);
        return imageView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StateUtils.getInstance(this).clearActivity();
    }
}
