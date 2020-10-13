package com.example.srmap;

import com.google.android.material.textfield.TextInputEditText;

public class Registerdetails {

    String name,lastname,email,phoneno,password,id;

    public Registerdetails(){}

    public Registerdetails(String name, String lastname, String email, String phoneno, String password, String id) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneno = phoneno;
        this.password = password;
        this.id=id;


    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
