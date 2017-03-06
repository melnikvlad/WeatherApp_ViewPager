package com.example.vlad.gzapp.Models.Sixteen_days;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.vlad.gzapp.Models.Five_Days.FiveDays;

import java.io.Serializable;
import java.util.List;

@Table(name = "SixteenDays")
public class SixteenDays extends Model implements Serializable{
    @Column(name = "city")
    public String city;
    @Column(name = "country")
    public String country;
    @Column (name = "temperature")
    public double temp;
    @Column (name = "temperature_min")
    public double min;
    @Column (name = "temperature_max")
    public double max;
    @Column (name = "morning")
    public double morn;
    @Column (name = "day")
    public double day;
    @Column (name = "evening")
    public double eve;
    @Column (name = "night")
    public double night;
    @Column (name = "humidity")
    public int hum;
    @Column (name = "pressure")
    public double pres;
    @Column(name = "condition")
    public String cond;
    @Column(name = "description")
    public String desc;
    @Column(name = "icon")
    public String icon;
    @Column (name = "clouds")
    public int clouds;
    @Column (name = "speed")
    public double speed;
    @Column (name = "deg")
    public double deg;

    public static List getAllWeather() {
        return new Select().from(SixteenDays.class).execute();
    }

    public SixteenDays() {
        super();
    }

    public SixteenDays(String city,
                       int clouds,
                       String cond,
                       String country,
                       double day,
                       double deg,
                       String desc,
                       double eve,
                       int hum,
                       String icon,
                       double max,
                       double min,
                       double morn,
                       double night,
                       double pres,
                       double speed,
                       double temp)
    {
        super();
        this.city = city;
        this.clouds = clouds;
        this.cond = cond;
        this.country = country;
        this.day = day;
        this.deg = deg;
        this.desc = desc;
        this.eve = eve;
        this.hum = hum;
        this.icon = icon;
        this.max = max;
        this.min = min;
        this.morn = morn;
        this.night = night;
        this.pres = pres;
        this.speed = speed;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "SixteenDays{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", temp=" + temp +
                ", min=" + min +
                ", max=" + max +
                ", morn=" + morn +
                ", day=" + day +
                ", eve=" + eve +
                ", night=" + night +
                ", hum=" + hum +
                ", pres=" + pres +
                ", cond='" + cond + '\'' +
                ", desc='" + desc + '\'' +
                ", icon='" + icon + '\'' +
                ", clouds=" + clouds +
                ", speed=" + speed +
                ", deg=" + deg +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getPres() {
        return pres;
    }

    public void setPres(double pres) {
        this.pres = pres;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
