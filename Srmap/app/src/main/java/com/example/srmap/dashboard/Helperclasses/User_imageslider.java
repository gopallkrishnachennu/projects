package com.example.srmap.dashboard.Helperclasses;

public class User_imageslider {
    String go;
    String imgurl;
    String title;

    public User_imageslider() {
    }

    public User_imageslider(String go, String imgurl, String title) {
        this.go = go;
        this.imgurl = imgurl;
        this.title = title;
    }

    public String getGo() {
        return go;
    }

    public void setGo(String go) {
        this.go = go;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
