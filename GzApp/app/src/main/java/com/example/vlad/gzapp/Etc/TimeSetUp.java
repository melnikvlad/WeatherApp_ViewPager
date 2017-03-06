package com.example.vlad.gzapp.Etc;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeSetUp {
    Calendar calendar;
    Date anotherday;
    String[] days;
    DateFormat dateFormat;
    public String[] DateView(int days_num)
    {
        calendar = Calendar.getInstance();
        days = new String[days_num];
        dateFormat = new SimpleDateFormat("dd MMMM yy HH:mm");

        for(int i = 0;i<days_num;i++)
        {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            anotherday = calendar.getTime();
            days[i] = dateFormat.format(anotherday);
        }
        return days;
    }

    public TimeSetUp() {
    }
}
