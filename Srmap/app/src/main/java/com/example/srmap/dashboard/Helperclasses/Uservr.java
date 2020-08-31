package com.example.srmap.dashboard.Helperclasses;

public class Uservr {
    private int image;
    private String names;
    private String url;

    public Uservr(int image, String names, String url) {
        this.image = image;
        this.names = names;
        this.url=url;
    }

    public int getImage() {
        return image;
    }

    public String getNames() {
        return names;
    }

    public String getUrl() {
        return url;
    }
}
