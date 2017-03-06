package com.example.vlad.gzapp.Etc;



public class ListInfo {
    public String iconn;
    public String date;
    public String temp;

    public ListInfo() {
    }

    public ListInfo(String date, String iconn, String temp) {
        super();
        this.date = date;
        this.iconn = iconn;
        this.temp = temp;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIconn() {
        return iconn;
    }

    public void setIconn(String iconn) {
        this.iconn = iconn;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
