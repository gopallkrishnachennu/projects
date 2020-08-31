package com.example.srmap.dashboard.Helperclasses;

import androidx.recyclerview.widget.RecyclerView;
import com.example.srmap.dashboard.Adapters.Myadapter_prof;

import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Userprof  {
    String images;

String Name;
String description;
String seconddescription;
String stamp;

    public Userprof() {
    }



    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeconddescription() {
        return seconddescription;
    }

    public void setSeconddescription(String seconddescription) {
        this.seconddescription = seconddescription;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }
}
