package com.example.vlad.gzapp.Parsers;

import com.example.vlad.gzapp.Models.Current_Weather.DailyForecast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyParser {

    DailyForecast model;
    double temp,tmin,tmax,speed,pressure;
    String condition,description,icon,dt,city,country;
    int clouds,deg,humidity;
    JSONArray list_arr,weather_arr;
    JSONObject clouds_obj,wind_obj,weather_obj,main_obj,country_obj;

    public DailyForecast getDailyData(JSONObject jsonObject) throws JSONException {

        model       = new DailyForecast();

        weather_arr = jsonObject.getJSONArray("weather");
        weather_obj = weather_arr.getJSONObject(0);
        main_obj    = jsonObject.getJSONObject("main");
        wind_obj    = jsonObject.getJSONObject("wind");
        clouds_obj  = jsonObject.getJSONObject("clouds");
        country_obj = jsonObject.getJSONObject("sys");

        temp        = getDouble("temp",         main_obj);
        humidity    = getInt(   "humidity",     main_obj);
        pressure    = getDouble("pressure",     main_obj);
        tmin        = getDouble("temp_min",     main_obj);
        tmax        = getDouble("temp_max",     main_obj);
        city        = getString("name",         jsonObject);
        country     = getString("country",      country_obj);
        condition   = getString("main",         weather_obj);
        description = getString("description",  weather_obj);
        icon        = getString("icon",         weather_obj);
        speed       = getDouble("speed",        wind_obj);
        clouds      = getInt(   "all",          clouds_obj);
        deg         = getInt(   "deg",          wind_obj);

        model.setMorning(temp);
        model.setMin(tmin);
        model.setMax(tmax);
        model.setCondition(condition);
        model.setDescription(description);
        model.setIcon(icon);
        model.setSpeed(speed);
        model.setClouds(clouds);
        model.setDeg(deg);
        model.setHumidity(humidity);
        model.setPressure(pressure);
        model.setCity(city);
        model.setCountry(country);

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
