package com.android_examples.autoimageslider_android_examplescom;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    SliderLayout sliderLayout;
    RecyclerView recyclerview_id;
    ItemAdapter itemAdapter;
    ArrayList<String> bennrList;
    int bannerCount;
    Timer timer;
    ImageView img1,img2,img3,img4,img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bennrList = new ArrayList<>();


        recyclerview_id = (RecyclerView) findViewById(R.id.recyclerview_id);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);

        bennrList.add("http://androidblog.esy.es/images/cupcake-1.png");
        bennrList.add("http://androidblog.esy.es/images/donut-2.png");
        bennrList.add("http://androidblog.esy.es/images/eclair-3.png");
        bennrList.add("http://androidblog.esy.es/images/images/froyo-4.png");
        bennrList.add("http://androidblog.esy.es/images/images/gingerbread-5.png");


        final ViewPager draweeView = (ViewPager) findViewById(R.id.sdvImage);

        AndroidImageAdapter  adapterView = new AndroidImageAdapter(MainActivity.this,bennrList);
        draweeView.setAdapter(adapterView);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (bannerCount == bennrList.size()-1) {
                    bannerCount = 0;
                }
                draweeView.setCurrentItem(bannerCount++, true);
                if (bannerCount == 1)
                {
                    img1.setBackground(getResources().getDrawable(R.drawable.dot));
                    img2.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img3.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img4.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img5.setBackground(getResources().getDrawable(R.drawable.circle_outline));

                }else  if (bannerCount == 2)
                {
                    img2.setBackground(getResources().getDrawable(R.drawable.dot));
                    img1.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img3.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img4.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img5.setBackground(getResources().getDrawable(R.drawable.circle_outline));

                }else  if (bannerCount == 3)
                {
                    img3.setBackground(getResources().getDrawable(R.drawable.dot));
                    img2.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img1.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img4.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img5.setBackground(getResources().getDrawable(R.drawable.circle_outline));

                }else  if (bannerCount == 4)
                {
                    img4.setBackground(getResources().getDrawable(R.drawable.dot));
                    img2.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img3.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img1.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img5.setBackground(getResources().getDrawable(R.drawable.circle_outline));

                }else  if (bannerCount == 5)
                {
                    img5.setBackground(getResources().getDrawable(R.drawable.dot));
                    img2.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img3.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img4.setBackground(getResources().getDrawable(R.drawable.circle_outline));
                    img1.setBackground(getResources().getDrawable(R.drawable.circle_outline));

                }
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 500, 3000);

        itemAdapter = new ItemAdapter(MainActivity.this, R.layout.item_row);
        RecyclerView.LayoutManager dashboradLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview_id.setLayoutManager(dashboradLayoutManager);
        recyclerview_id.setItemAnimator(new DefaultItemAnimator());
        recyclerview_id.setAdapter(itemAdapter);
    }
    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }
}
