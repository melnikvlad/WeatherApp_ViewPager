package com.example.vlad.gzapp.Etc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vlad.gzapp.R;



public class MemberViewHolder extends RecyclerView.ViewHolder
{
    public TextView date,temp;
    public ImageView icon;

    public MemberViewHolder(View itemView) {
        super(itemView);
        date = (TextView) itemView.findViewById(R.id.date);
        temp = (TextView) itemView.findViewById(R.id.temp);
        icon = (ImageView) itemView.findViewById(R.id.icon);
    }
}