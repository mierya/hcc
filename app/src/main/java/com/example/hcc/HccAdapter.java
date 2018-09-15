package com.example.hcc;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by vera on 2018/4/9.
 */

public class HccAdapter extends RecyclerView.Adapter<HccAdapter.ViewHolder>
{
    private Context mContext;
    private List<Hcc> mHccList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView hccImage;
        TextView hccName;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView)view;
            hccImage = (ImageView)view.findViewById(R.id.hcc_image);
            hccName = (TextView)view.findViewById(R.id.hcc_name);
        }
    }
    public HccAdapter(List<Hcc> hccList){
        mHccList = hccList;
    }
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.hcc_item,
                parent,false);
        return new ViewHolder(view);
    }
    public void onBindViewHolder(ViewHolder holder,int position){
        Hcc hcc = mHccList.get(position);
        holder.hccName.setText(hcc.getName());
        Glide.with(mContext).load(hcc.getImageId()).into(holder.hccImage);
    }
    public int getItemCount(){
        return mHccList.size();
    }
}
