package com.example.srmap.dashboard.Helperclasses;

public class User_collaborate {
    private String course,time;

    public User_collaborate() {
    }

    public User_collaborate(String course, String time) {
        this.course = course;
        this.time = time;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
