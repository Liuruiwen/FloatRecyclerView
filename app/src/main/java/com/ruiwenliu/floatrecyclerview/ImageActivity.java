package com.ruiwenliu.floatrecyclerview;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private  BitmapDrawable bitmapDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView=findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.img_mm);
//         bitmapDrawable=BitmapUtil.getInstance(this).createBitmapDrawable(R.drawable.img_mm);
//
//        imageView.setImageDrawable(bitmapDrawable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Bitmap bitmap = bitmapDrawable.getBitmap();
//        if(bitmap != null && !bitmap.isRecycled()){
//            bitmap.recycle();
//        }
//        BitmapUtil.getInstance(this).clearContext();
//        if(imageView!=null){
//            imageView.setImageDrawable(null);
//        }
    }
}
