package com.example.vlad.gzapp.Models.Current_Weather;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;


import java.io.Serializable;
import java.util.List;

@Table(name = "DailyWeather")
public class DailyForecast extends Model implements Serializable {
    @Column(name = "City")
    public String city;
    @Column(name = "Country")
    public String country;
    @Column(name = "Rain")
    public double rain;
    @Column(name = "Clouds")
    public int clouds;
    @Column(name = "Deg")
    public int deg;
    @Column(name = "Speed")
    public double speed;
    @Column(name = "Dt")
    public String dt;
    @Column(name = "Pressure")
    public double pressure;
    @Column(name = "Humidity")
    public int humidity;
    @Column(name = "Morning")
    public double morning;
    public double night;
    @Column(name = "Min")
    public double min;
    @Column(name = "Max")
    public double max;
    @Column(name = "Condition")
    public String condition;
    @Column(name = "Description")
    public String description;
    @Column(name = "Icon")
    public String icon;

    public static List getAllWeather() {
        return new Select().from(DailyForecast.class).execute();
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }


    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
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

    public double getMorning() {
        return morning;
    }

    public void setMorning(double morning) {
        this.morning = morning;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public DailyForecast()
    {
        super();
    }

    public DailyForecast(String city,
                         int clouds,
                         String condition,
                         String country,
                         double day,
                         int deg,
                         String description,
                         String dt,
                         double evening,
                         int humidity,
                         String icon,
                         double max,
                         double min,
                         double morning,
                         double night,
                         double pressure,
                         double rain,
                         double speed) {
        super();
        this.city = city;
        this.clouds = clouds;
        this.condition = condition;
        this.country = country;

        this.deg = deg;
        this.description = description;
        this.dt = dt;

        this.humidity = humidity;
        this.icon = icon;
        this.max = max;
        this.min = min;
        this.morning = morning;
        this.night = night;
        this.pressure = pressure;
        this.rain = rain;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "DailyForecast{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", rain=" + rain +
                ", clouds=" + clouds +
                ", deg=" + deg +
                ", speed=" + speed +
                ", dt='" + dt + '\'' +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", morning=" + morning +
                ", night=" + night +
                ", min=" + min +
                ", max=" + max +
                ", condition='" + condition + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
