package com.example.vlad.gzapp.Etc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vlad.gzapp.R;

import java.util.List;



public class RVAdapter extends RecyclerView.Adapter<MemberViewHolder>
{
    private List<ListInfo> members;
    private Context context;
    int[] icons = { R.drawable.icon_01d,
            R.drawable.icon_02d,
            R.drawable.icon_03d,
            R.drawable.icon_04d,
            R.drawable.icon_09d,
            R.drawable.icon_10d,
            R.drawable.icon_11d,
            R.drawable.icon_13d,
            R.drawable.icon_50d};
    int[] iconss = {R.drawable.icon_01n,
            R.drawable.icon_02n,
            R.drawable.icon_03n,
            R.drawable.icon_04n,
            R.drawable.icon_09n,
            R.drawable.icon_10n,
            R.drawable.icon_11n,
            R.drawable.icon_13n};

    public RVAdapter(Context context, List<ListInfo> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        MemberViewHolder memberViewHolder = new MemberViewHolder(view);

        return memberViewHolder;
    }


    @Override
    public void onBindViewHolder(MemberViewHolder holder, int i) {

        holder.date.setText(members.get(i).getDate());
        holder.temp.setText(members.get(i).getTemp());

        switch (members.get(i).getIconn())
        {
            case "01d":
                holder.icon.setImageResource(icons[0]);
                break;
            case "02d":
                holder.icon.setImageResource(icons[1]);
                break;
            case "03d":
                holder.icon.setImageResource(icons[2]);
                break;
            case "04d":
                holder.icon.setImageResource(icons[3]);
                break;
            case "09d":
                holder.icon.setImageResource(icons[4]);
                break;
            case "10d":
                holder.icon.setImageResource(icons[5]);
                break;
            case "11d":
                holder.icon.setImageResource(icons[6]);
                break;
            case "13d":
                holder.icon.setImageResource(icons[7]);
                break;
            case "50d":
                holder.icon.setImageResource(icons[8]);
                break;
            case "01n":
                holder.icon.setImageResource(iconss[0]);
                break;
            case "02n":
                holder.icon.setImageResource(iconss[1]);
                break;
            case "03n":
                holder.icon.setImageResource(iconss[2]);
                break;
            case "04n":
                holder.icon.setImageResource(iconss[3]);
                break;
            case "09n":
                holder.icon.setImageResource(iconss[4]);
                break;
            case "10n":
                holder.icon.setImageResource(iconss[5]);
                break;
            case "11n":
                holder.icon.setImageResource(iconss[6]);
                break;
            case "13n":
                holder.icon.setImageResource(iconss[7]);
                break;
            case "50n":
                holder.icon.setImageResource(icons[8]);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

}
