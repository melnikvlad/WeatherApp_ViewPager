package com.example.vlad.gzapp.Fragments;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.example.vlad.gzapp.Etc.ListInfo;
import com.example.vlad.gzapp.Etc.RVAdapter;
import com.example.vlad.gzapp.HTTP.HttpConnection;
import com.example.vlad.gzapp.Models.Current_Weather.DailyForecast;
import com.example.vlad.gzapp.Parsers.DailyParser;
import com.example.vlad.gzapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentWeatherFragment extends Fragment {
    List<DailyForecast> storedWeather;
    Map<String, String> m;
    int[] icon = {
            R.drawable.temperature,
            R.drawable.humidity,
            R.drawable.pressure,
            R.drawable.clouds,
            R.drawable.deg,
            R.drawable.wind
    };
    int[] icons = {R.drawable.icon_01d,
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
    final String ATR_TEMP = "temp";
    final String ATR_TEMP_MIN = "tempmin";
    final String ATR_TEMP_MAX = "tempmax";
    final String ATR_HUM = "humidity";
    final String ATR_PRES = "pressure";
    final String ATR_CITY = "city";
    final String ATR_COUNTRY = "country";
    final String ATR_COND = "condition";
    final String ATR_DESCR = "description";
    final String ATR_IC = "icon";
    final String ATR_SPEED = "speed";
    final String ATR_CLOUDS = "clouds";
    final String ATR_DEG = "deg";
    private final static String addres = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final static String api_key = "&appid=7b5abb359df4f893ab31852495726aa0";
    TextView mintemp;
    TextView tempr;
    TextView maxtemp;
    TextView humidity;
    TextView pressure;
    TextView condition;
    TextView description;
    TextView clouds;
    TextView speed;
    TextView deg;
    ImageView temp, hum, pres, ic, spd, dg, cld;

    public CurrentWeatherFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);

        mintemp = (TextView) view.findViewById(R.id.min_temp);
        tempr = (TextView) view.findViewById(R.id.temp);
        maxtemp = (TextView) view.findViewById(R.id.max_temp);
        humidity = (TextView) view.findViewById(R.id.hum);
        pressure = (TextView) view.findViewById(R.id.pres);
        condition = (TextView) view.findViewById(R.id.cond);
        description = (TextView) view.findViewById(R.id.desc);
        clouds = (TextView) view.findViewById(R.id.clouds);
        speed = (TextView) view.findViewById(R.id.wind);
        deg = (TextView) view.findViewById(R.id.deg);
        temp = (ImageView) view.findViewById(R.id.icon_temp);
        hum = (ImageView) view.findViewById(R.id.icon_hum);
        pres = (ImageView) view.findViewById(R.id.icon_pres);
        ic = (ImageView) view.findViewById(R.id.icon);
        cld = (ImageView) view.findViewById(R.id.icon_cloud);
        spd = (ImageView) view.findViewById(R.id.icon_wind);
        dg = (ImageView) view.findViewById(R.id.icon_deg);

        temp.setImageResource(icon[0]);
        hum.setImageResource(icon[1]);
        pres.setImageResource(icon[2]);
        cld.setImageResource(icon[3]);
        dg.setImageResource(icon[4]);
        spd.setImageResource(icon[5]);

        new InflateList().execute();

        return view;
    }

    public class InflateList extends AsyncTask<Object, Object, Map<String, String>> {
        HttpConnection httpConnection;
        JSONObject jsonObject;
        DailyParser dailyParser;
        DailyForecast weather;
        RVAdapter adapter;


        @Override
        public Map<String, String> doInBackground(Object... params) {
            httpConnection = new HttpConnection();
            jsonObject = new JSONObject();
            dailyParser = new DailyParser();

            try {
                jsonObject = httpConnection.HttpRequest(addres, "Rostov-na-Donu", api_key);
                new Delete().from(DailyForecast.class).execute();

                ActiveAndroid.beginTransaction();
                for (int i = 0; i < 36; i += 8) {
                    weather = new DailyForecast();
                    weather = dailyParser.getDailyData(jsonObject);
                    weather.save();
                }
                ActiveAndroid.setTransactionSuccessful();
                ActiveAndroid.endTransaction();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            storedWeather = DailyForecast.getAllWeather();


            m = new HashMap<String, String>();

            m.put(ATR_TEMP, String.valueOf(storedWeather.get(0).getMorning()) + "°C");
            m.put(ATR_TEMP_MIN, String.valueOf(storedWeather.get(0).getMin()));
            m.put(ATR_TEMP_MAX, String.valueOf(storedWeather.get(0).getMax()));
            m.put(ATR_HUM, String.valueOf(storedWeather.get(0).getHumidity()));
            m.put(ATR_PRES, String.valueOf(storedWeather.get(0).getPressure()));
            m.put(ATR_CITY, storedWeather.get(0).getCity());
            m.put(ATR_COUNTRY, storedWeather.get(0).getCountry());
            m.put(ATR_COND, String.valueOf(storedWeather.get(0).getCondition()));
            m.put(ATR_DESCR, String.valueOf(storedWeather.get(0).getDescription()));
            m.put(ATR_IC, storedWeather.get(0).getIcon());
            m.put(ATR_SPEED, String.valueOf(storedWeather.get(0).getSpeed()));
            m.put(ATR_CLOUDS, String.valueOf(storedWeather.get(0).getClouds() + "%"));
            m.put(ATR_DEG, String.valueOf(storedWeather.get(0).getDeg() + "°"));

            return m;
        }

        @Override
        protected void onPostExecute(Map<String, String> weather) {
            super.onPostExecute(weather);

                mintemp.setText(weather.get(ATR_TEMP_MIN));
                tempr.setText(weather.get(ATR_TEMP));
                maxtemp.setText(weather.get(ATR_TEMP_MAX));
                humidity.setText(weather.get(ATR_HUM));
                pressure.setText(weather.get(ATR_PRES));
                condition.setText(weather.get(ATR_COND));
                description.setText(weather.get(ATR_DESCR));
                clouds.setText(weather.get(ATR_CLOUDS));
                speed.setText(weather.get(ATR_SPEED));
                deg.setText(weather.get(ATR_DEG));
                switch (weather.get(ATR_IC)) {
                    case "01d":
                        ic.setImageResource(icons[0]);
                        break;
                    case "02d":
                        ic.setImageResource(icons[1]);
                        break;
                    case "03d":
                        ic.setImageResource(icons[2]);
                        break;
                    case "04d":
                        ic.setImageResource(icons[3]);
                        break;
                    case "09d":
                        ic.setImageResource(icons[4]);
                        break;
                    case "10d":
                        ic.setImageResource(icons[5]);
                        break;
                    case "11d":
                        ic.setImageResource(icons[6]);
                        break;
                    case "13d":
                        ic.setImageResource(icons[7]);
                        break;
                    case "50d":
                        ic.setImageResource(icons[8]);
                        break;
                    case "01n":
                        ic.setImageResource(iconss[0]);
                        break;
                    case "02n":
                        ic.setImageResource(iconss[1]);
                        break;
                    case "03n":
                        ic.setImageResource(iconss[2]);
                        break;
                    case "04n":
                        ic.setImageResource(iconss[3]);
                        break;
                    case "09n":
                        ic.setImageResource(iconss[4]);
                        break;
                    case "10n":
                        ic.setImageResource(iconss[5]);
                        break;
                    case "11n":
                        ic.setImageResource(iconss[6]);
                        break;
                    case "13n":
                        ic.setImageResource(iconss[7]);
                        break;
                    case "50n":
                        ic.setImageResource(icons[8]);
                        break;
                }
            }
        }
    }

