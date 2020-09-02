package com.m.k.banner;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libbanner.R;

import java.util.ArrayList;

public abstract class SimpleBannerAdapter extends BannerAdapter<SimpleBannerAdapter.SimpleBannerHolder> {


    private static int mCount =0;

    private ArrayList<? extends IBannerData> mDatas;


    public SimpleBannerAdapter(ArrayList<? extends IBannerData> datas) {
        this.mDatas = datas;
    }

    @NonNull
    @Override
    public SimpleBannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setTag(mCount);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        return new SimpleBannerHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleBannerHolder holder, int position) {
        position = position % mDatas.size();

        bindData((ImageView) holder.itemView,mDatas.get(position));
    }

    public abstract void bindData(ImageView view,IBannerData data);

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : Integer.MAX_VALUE;
    }


    @Override
    public void onViewRecycled(@NonNull SimpleBannerHolder holder) {
        super.onViewRecycled(holder);
        Log.d("Test","回收 页面 " + holder.itemView.getTag());
    }

    @Override
    protected   ArrayList<? extends IBannerData> getDataList() {
        return mDatas;
    }


    public class SimpleBannerHolder extends RecyclerView.ViewHolder{

        public SimpleBannerHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void setData(int id){
            itemView.setBackgroundResource(id);
        }
    }


}
