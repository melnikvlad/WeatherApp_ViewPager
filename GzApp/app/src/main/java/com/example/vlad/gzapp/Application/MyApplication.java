package com.example.vlad.gzapp.Application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.example.vlad.gzapp.Models.Current_Weather.DailyForecast;
import com.example.vlad.gzapp.Models.FavouriteCitiesModel;
import com.example.vlad.gzapp.Models.Five_Days.FiveDays;
import com.example.vlad.gzapp.Models.Sixteen_days.SixteenDays;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration.Builder configurationBuilder = new Configuration.Builder(this);

        configurationBuilder.addModelClass(DailyForecast.class);

        configurationBuilder.addModelClass(FiveDays.class);

        configurationBuilder.addModelClass(SixteenDays.class);

        configurationBuilder.addModelClass(FavouriteCitiesModel.class);

        ActiveAndroid.initialize(configurationBuilder.create());
    }
}
