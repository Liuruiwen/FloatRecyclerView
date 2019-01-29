package com.ruiwenliu.floatrecyclerview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.ruiwenliu.floatrecyclerview.until.BitmapUtil;

public class TestActivity extends AppCompatActivity {

    private ImageView imageView;
    private BitmapDrawable bitmapDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView=findViewById(R.id.image);
        bitmapDrawable= BitmapUtil.getInstance().createBitmapDrawable(R.drawable.xiao_jie_jie);
        imageView.setImageDrawable(bitmapDrawable);
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if(bitmap != null && !bitmap.isRecycled()){
            bitmap.recycle();
        }
        if(imageView!=null){
            imageView.setImageDrawable(null);
            imageView=null;
        }
    }
}
