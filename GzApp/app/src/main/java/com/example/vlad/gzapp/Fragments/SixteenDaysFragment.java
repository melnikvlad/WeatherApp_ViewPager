package com.example.vlad.gzapp.Fragments;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;

import com.example.vlad.gzapp.Etc.ListInfo;
import com.example.vlad.gzapp.Etc.RVAdapter;
import com.example.vlad.gzapp.Etc.RecyclerItemClickListener;
import com.example.vlad.gzapp.Etc.TimeSetUp;
import com.example.vlad.gzapp.HTTP.HttpConnection;

import com.example.vlad.gzapp.Models.Sixteen_days.SixteenDays;

import com.example.vlad.gzapp.Parsers.SixteenDaysParser;
import com.example.vlad.gzapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class SixteenDaysFragment extends Fragment {
    TimeSetUp date;
    String[] dates;
    List<SixteenDays> storedWeather;
    Map<String, String> m;
    ArrayList<Map<String, String>> data;
    final String ATR_DATE       = "date";
    final String ATR_TEMP       = "temp";
    final String ATR_IC         = "icon";
    final String ATR_TEMP_MIN   = "tempmin";
    final String ATR_TEMP_MAX   = "tempmax";
    final String ATR_TEMP_MORN  = "morning";
    final String ATR_TEMP_DAY   = "day";
    final String ATR_TEMP_EVE   = "evening";
    final String ATR_TEMP_NIGHT = "night";
    final String ATR_HUM        = "humidity";
    final String ATR_PRES       = "pressure";
    final String ATR_CITY       = "city";
    final String ATR_COUNTRY    = "country";
    final String ATR_COND       = "condition";
    final String ATR_DESCR      = "description";
    final String ATR_SPEED      = "speed";
    final String ATR_CLOUDS     = "clouds";
    final String ATR_DEG        = "deg";
    private final static String addres = "http://api.openweathermap.org/data/2.5/forecast/daily?q=";
    private final static String api_key = "&mode=json&units=metric&cnt=16&appid=7b5abb359df4f893ab31852495726aa0";
    RecyclerView recyclerview;
    private List<ListInfo> meberlist;
    LinearLayoutManager layoutManager;

    public SixteenDaysFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sixteen_days, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerview.hasFixedSize();
        data = new ArrayList<Map<String, String>>();
        meberlist = new ArrayList<ListInfo>();
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        date = new TimeSetUp();
        dates = new String[16];
        dates = date.DateView(16);
        new InflateList().execute();

        recyclerview.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerview ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        View customView = inflater.inflate(R.layout.sixteendays,null);
                        final PopupWindow mPopupWindow = new PopupWindow(
                                customView,
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                        );

                        if(Build.VERSION.SDK_INT>=21){
                            mPopupWindow.setElevation(5.0f);

                        }
                        ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);
                        TextView date = (TextView) customView.findViewById(R.id.date);
                        TextView morn = (TextView) customView.findViewById(R.id.morn);
                        TextView day = (TextView) customView.findViewById(R.id.day);
                        TextView eve = (TextView) customView.findViewById(R.id.eve);
                        TextView night = (TextView) customView.findViewById(R.id.night);
                        TextView cond = (TextView) customView.findViewById(R.id.cond);
                        TextView desc = (TextView) customView.findViewById(R.id.desc);
                        TextView hum = (TextView) customView.findViewById(R.id.hum);
                        TextView pres = (TextView) customView.findViewById(R.id.pres);
                        TextView speed = (TextView) customView.findViewById(R.id.wind);
                        TextView deg = (TextView) customView.findViewById(R.id.deg);
                        TextView clouds = (TextView) customView.findViewById(R.id.clouds);

                        closeButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mPopupWindow.dismiss();
                            }
                        });
                        date.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_DATE));
                        morn.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_TEMP_MORN));
                        day.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_TEMP_DAY));
                        eve.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_TEMP_EVE));
                        night.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_TEMP_NIGHT));
                        cond.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_COND));
                        desc.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_DESCR));
                        hum.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_HUM));
                        pres.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_PRES));
                        speed.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_SPEED));
                        deg.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_DEG));
                        clouds.setText(data.get(recyclerview.getChildLayoutPosition(view)).get(ATR_CLOUDS));


                        mPopupWindow.setBackgroundDrawable(new ColorDrawable(
                                Color.BLACK));
                        mPopupWindow.showAtLocation(recyclerview, Gravity.CENTER,0,0);
                    }
                })
        );
        return view;
    }

    public class InflateList extends AsyncTask<Object, Object, ArrayList<Map<String, String>>> {
        HttpConnection httpConnection;
        JSONObject jsonObject;
        SixteenDaysParser sixteenDaysParser;
        SixteenDays weather;
        RVAdapter adapter;

        @Override
        public ArrayList<Map<String, String>> doInBackground(Object... params) {
            httpConnection = new HttpConnection();
            jsonObject = new JSONObject();

            sixteenDaysParser= new SixteenDaysParser();

            try {
                jsonObject = httpConnection.HttpRequest(addres,"Rostov-na-Donu",api_key);

                new Delete().from(SixteenDays.class).execute();
                ActiveAndroid.beginTransaction();
                for (int i=0;i<16;i++)
                {
                    weather = new SixteenDays();
                    weather = sixteenDaysParser.getData(jsonObject,i);
                    weather.save();
                }
                ActiveAndroid.setTransactionSuccessful();
                ActiveAndroid.endTransaction();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            storedWeather = SixteenDays.getAllWeather();

            for (int i=0;i<storedWeather.size();i++) {
                m = new HashMap<String, String>();
                m.put(ATR_DATE,     dates[i]);
                m.put(ATR_IC,       storedWeather.get(i).getIcon());
                m.put(ATR_TEMP,     String.valueOf(storedWeather.get(i).getTemp())+"°C");
                m.put(ATR_TEMP_MIN, String.valueOf(storedWeather.get(i).getMin()+"°C"));
                m.put(ATR_TEMP_MAX, String.valueOf(storedWeather.get(i).getMax()+"°C"));
                m.put(ATR_TEMP_MORN,String.valueOf(storedWeather.get(i).getMorn())+"°C");
                m.put(ATR_TEMP_EVE, String.valueOf(storedWeather.get(i).getEve()+"°C"));
                m.put(ATR_TEMP_NIGHT,String.valueOf(storedWeather.get(i).getNight()+"°C"));
                m.put(ATR_TEMP_DAY, String.valueOf(storedWeather.get(i).getDay()+"°C"));
                m.put(ATR_HUM,      String.valueOf(storedWeather.get(i).getHum()));
                m.put(ATR_PRES,     String.valueOf(storedWeather.get(i).getPres()));
                m.put(ATR_CITY,     storedWeather.get(i).getCity());
                m.put(ATR_COUNTRY,  storedWeather.get(i).getCountry());
                m.put(ATR_COND,     storedWeather.get(i).getCond());
                m.put(ATR_DESCR,    storedWeather.get(i).getDesc());
                m.put(ATR_SPEED,    String.valueOf(storedWeather.get(i).getSpeed()));
                m.put(ATR_CLOUDS,   String.valueOf(storedWeather.get(i).getClouds()));
                m.put(ATR_DEG,      String.valueOf(storedWeather.get(i).getDeg()));

                data.add(m);
            }
            Log.e("SixTEEN LOG",data.toString());
            return data;
        }

        @Override
        protected void onPostExecute(ArrayList<Map<String, String>> weather) {
            super.onPostExecute(weather);

            for(int i=0;i<weather.size();i++)
            {


                ListInfo member = new ListInfo(
                        weather.get(i).get(ATR_DATE),
                        weather.get(i).get(ATR_IC),
                        weather.get(i).get(ATR_TEMP_EVE)
                );
                meberlist.add(member);
            }
            adapter = new RVAdapter(getContext(),meberlist);
            recyclerview.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}
