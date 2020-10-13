package com.example.srmap.dashboard.Helperclasses;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class User_itsupport  {
    String assign;
    String email;


    public User_itsupport() {
    }

    public User_itsupport(String assign, String email) {
        this.assign = assign;
        this.email = email;

    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
