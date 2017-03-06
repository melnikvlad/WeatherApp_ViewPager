package com.example.vlad.gzapp.Parsers;




import com.example.vlad.gzapp.Models.Sixteen_days.SixteenDays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SixteenDaysParser {
    SixteenDays model;
    JSONObject temp_obj,weather_obj,item,clouds_obj,wind_obj,city_obj;
    JSONArray list_arr,weather_arr;
    String conditon,description,icon,city,country;
    double temp,min,max,pressure,speed,deg,morn,day,eve,night;
    int humidity,clouds;
    public SixteenDays getData(JSONObject jsonObject, int time) throws JSONException {
        model= new SixteenDays();

        city_obj    =jsonObject.getJSONObject("city");
        list_arr    = jsonObject.getJSONArray("list");
        item        = list_arr.getJSONObject(time);
        temp_obj    = item.getJSONObject("temp");
        weather_arr = item.getJSONArray("weather");
        weather_obj = weather_arr.getJSONObject(0);


        city        = getString("name",         city_obj);
        country     = getString("country",      city_obj);
        min         = getDouble("min",     temp_obj);
        max         = getDouble("max",     temp_obj);
        morn        = getDouble("morn",         temp_obj);
        day         = getDouble("day",          temp_obj);
        eve         = getDouble("eve",          temp_obj);
        night       = getDouble("night",        temp_obj);
        pressure    = getDouble("pressure",     item);
        humidity    = getInt("humidity",        item);
        conditon    = getString("main",         weather_obj);
        description = getString("description",  weather_obj);
        icon        = getString("icon",         weather_obj);
        clouds      = getInt(   "clouds",       item);
        speed       = getDouble("speed",        item);
        deg         = getDouble("deg",          item);

        model.setCity(city);
        model.setCountry(country);
        model.setTemp(temp);
        model.setMin(min);
        model.setMax(max);
        model.setMorn(morn);
        model.setDay(day);
        model.setEve(eve);
        model.setNight(night);
        model.setPres(pressure);
        model.setHum(humidity);
        model.setDesc(description);
        model.setCond(conditon);
        model.setIcon(icon);
        model.setClouds(clouds);
        model.setSpeed(speed);
        model.setDeg(deg);

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
