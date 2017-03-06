package com.example.vlad.gzapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.example.vlad.gzapp.Etc.FavItemData;
import com.example.vlad.gzapp.Etc.MyAdapter;
import com.example.vlad.gzapp.Etc.RecyclerItemClickListener;
import com.example.vlad.gzapp.Models.FavouriteCitiesModel;
import com.example.vlad.gzapp.R;

import java.util.ArrayList;
import java.util.List;


public class Favorites extends Activity {
    List<FavouriteCitiesModel> storedweather;
    TextView edit ;
    MyAdapter mAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        // 1. get a reference to recyclerView
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


        // this is data fro recycler view
        storedweather = FavouriteCitiesModel.getAllWeather();
        List<String> favItemDatas = new ArrayList<>();
        for(int i=0;i<storedweather.size();i++)
        {
            Log.e("MODEL ",storedweather.get(i).getName());

           favItemDatas.add(i,storedweather.get(i).getName());

        }

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        mAdapter = new MyAdapter(favItemDatas);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }
    }

