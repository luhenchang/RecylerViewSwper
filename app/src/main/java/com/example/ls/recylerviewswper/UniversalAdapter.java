package com.example.ls.recylerviewswper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ls on 2017/11/25.
 */

public class UniversalAdapter extends RecyclerView.Adapter<UniversalAdapter.UniversalViewHolder> {
    public ArrayList<SwipeCardBean> mData;
    public Context context;

    public UniversalAdapter(ArrayList<SwipeCardBean> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public UniversalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylerview_item, null);
        UniversalViewHolder holder = new UniversalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UniversalViewHolder holder, int position) {
        UniversalViewHolder holder1=holder;
        holder1.recy_item_im.setBackgroundResource(mData.get(position).resoutimage);
        holder1.recy_item_tv.setText(mData.get(position).title);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class UniversalViewHolder extends RecyclerView.ViewHolder {
        public TextView recy_item_tv;
        public ImageView recy_item_im;

        public UniversalViewHolder(View itemView) {
            super(itemView);
            recy_item_im=itemView.findViewById(R.id.recy_item_im);
            recy_item_tv=itemView.findViewById(R.id.recy_item_tv);
        }
    }
}