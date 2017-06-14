package com.android_examples.autoimageslider_android_examplescom;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by aleaphp23 on 19/4/17.
 */


 public  class AndroidImageAdapter extends PagerAdapter {
        Context mContext;
        ArrayList<String> data;
    public AndroidImageAdapter(Context context, ArrayList<String> data) {
            this.mContext = context;
            this.data = data;
        }
    @Override
    public int getCount() {
            return data.size();
        }
    @Override
    public boolean isViewFromObject(View v, Object obj) {
            return v == ((ImageView) obj);
        }
    @Override
    public Object instantiateItem(ViewGroup container, int i) {
            ImageView mImageView = new ImageView(mContext);
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            Picasso.with(mContext).load(data.get(i)).into(mImageView);
            ((ViewPager) container).addView(mImageView, 0);
            return mImageView;
        }
    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
            ((ViewPager) container).removeView((ImageView) obj);
        }
    }

