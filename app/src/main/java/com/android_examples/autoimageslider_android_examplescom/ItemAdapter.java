package com.android_examples.autoimageslider_android_examplescom;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ALEAANDROID on 16-01-2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    Context context;
    int ResourceId;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View view) {
            super(view);
        }
    }


    public ItemAdapter(Context context, int ResourceId) {
        this.context = context;
        this.ResourceId = ResourceId;

    }

    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(ResourceId, parent, false);

        return new ItemAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemAdapter.MyViewHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
