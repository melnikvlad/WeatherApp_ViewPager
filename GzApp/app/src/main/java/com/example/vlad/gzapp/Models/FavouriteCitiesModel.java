package com.example.vlad.gzapp.Models;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.vlad.gzapp.Models.Sixteen_days.SixteenDays;

import java.io.Serializable;
import java.util.List;

@Table(name = "Cities")
public class FavouriteCitiesModel extends Model implements Serializable {
    @Column(name = "name")
    public String name;

    public static List getAllWeather() {
        return new Select().from(FavouriteCitiesModel.class).execute();
    }

    public FavouriteCitiesModel() {
        super();
    }

    public FavouriteCitiesModel(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
