package com.example.vlad.gzapp.Activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.activeandroid.query.Delete;
import com.example.vlad.gzapp.Fragments.CurrentWeatherFragment;
import com.example.vlad.gzapp.Fragments.FiveDaysPerThreeHourFragment;
import com.example.vlad.gzapp.Fragments.SixteenDaysFragment;
import com.example.vlad.gzapp.Models.FavouriteCitiesModel;
import com.example.vlad.gzapp.Models.Five_Days.FiveDays;
import com.example.vlad.gzapp.R;

public class WeatherAllInformation extends FragmentActivity {
    TextView cityview;
    ImageButton addbtn;
    TabLayout tabLayout;
    ViewPager viewPager;
    CurrentWeatherFragment currentWeatherFragment;
    SixteenDaysFragment sixteenDaysFragment;
    FiveDaysPerThreeHourFragment fiveDaysPerThreeHourFragment;
    FavouriteCitiesModel favouriteCitiesModel;
    Intent intent;
    String city;
    private static String cityconst = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        cityview = (TextView)findViewById(R.id.cityID);
        city = getIntent().getStringExtra("CITY");
        cityconst = city;
        cityview.setText(cityconst);
        favouriteCitiesModel = new FavouriteCitiesModel();
        addbtn = (ImageButton)findViewById(R.id.imageButton2);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new Delete().from(FavouriteCitiesModel.class).execute();
                favouriteCitiesModel.setName(cityview.getText().toString());
                favouriteCitiesModel.save();
                intent = new Intent(getApplicationContext(),Favorites.class);
                intent.putExtra("CITYADD",city);
                startActivity(intent);
                finish();
            }
        });

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));
        tabLayout.setupWithViewPager(viewPager);
    }


    private class CustomAdapter extends FragmentPagerAdapter {
        private String fragments []  = {"CURRENT","16 DAY'S","5 DAY'S"};
        Context context;

        public CustomAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    currentWeatherFragment = new CurrentWeatherFragment();
                    return currentWeatherFragment;
                case 1:
                    sixteenDaysFragment = new SixteenDaysFragment();
                    return sixteenDaysFragment;
                case 2:
                    fiveDaysPerThreeHourFragment = new FiveDaysPerThreeHourFragment();
                    return fiveDaysPerThreeHourFragment;


                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }
}
