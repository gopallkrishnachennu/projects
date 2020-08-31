package com.example.srmap.dashboard.Helperclasses;

public class Usercategory {
    String assign;
    String email;
    String image;
    String job;
    String name;
    Long phone;

    public Usercategory() {
    }

    public Usercategory(String assign, String email, String image, String job, String name, Long phone) {
        this.assign = assign;
        this.email = email;
        this.image = image;
        this.job = job;
        this.name = name;
        this.phone = phone;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
