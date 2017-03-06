package com.example.vlad.gzapp.Parsers;


import com.example.vlad.gzapp.Models.Five_Days.FiveDays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FiveDaysParser {
    FiveDays model;
    JSONObject main_obj,weather_obj,item,clouds_obj,wind_obj,city_obj;
    JSONArray list_arr,weather_arr;
    String date_txt,conditon,description,icon,city,country;
    double temp,min,max,pressure,speed,deg;
    int humidity,clouds;
    public FiveDays getData(JSONObject jsonObject, int time) throws JSONException {
        model= new FiveDays();

        city_obj    =jsonObject.getJSONObject("city");
        list_arr    = jsonObject.getJSONArray("list");
        item        = list_arr.getJSONObject(time);
        date_txt    = item.getString("dt_txt");
        main_obj    = item.getJSONObject("main");
        weather_arr = item.getJSONArray("weather");
        weather_obj = weather_arr.getJSONObject(0);
        clouds_obj  = item.getJSONObject("clouds");
        wind_obj  = item.getJSONObject("wind");

        city        = getString("name",     city_obj);
        country     = getString("country",  city_obj);
        temp        = getDouble("temp",     main_obj);
        min         = getDouble("temp_min", main_obj);
        max         = getDouble("temp_max", main_obj);
        pressure    = getDouble("pressure", main_obj);
        humidity    = getInt("humidity",    main_obj);
        conditon    = getString("main",     weather_obj);
        description = getString("description",weather_obj);
        icon        = getString("icon",     weather_obj);
        clouds      = getInt("all",         clouds_obj);
        speed       = getDouble("speed",    wind_obj);
        deg         = getDouble("deg",      wind_obj);

        model.setCity(city);
        model.setCountry(country);
        model.setTemp(temp);
        model.setMin(min);
        model.setMax(max);
        model.setPres(pressure);
        model.setHum(humidity);
        model.setDesc(description);
        model.setCond(conditon);
        model.setIcon(icon);
        model.setClouds(clouds);
        model.setSpeed(speed);
        model.setDeg(deg);
        model.setDate(date_txt);


        return model;
    }
    private static String getString(String val, JSONObject jObj) throws JSONException {
        return jObj.getString(val);
    }
    private static double  getDouble(String val, JSONObject jObj) throws JSONException {
        return (double) jObj.getDouble(val);
  }
   private static int  getInt(String val, JSONObject jObj) throws JSONException {
       return jObj.getInt(val);
  }
}
