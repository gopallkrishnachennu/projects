package com.example.srmap.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.srmap.R;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(Admin.this,"Press again to go back",Toast.LENGTH_LONG).show();
        Intent intent =new Intent(Admin.this,Srm.class);
        startActivity(intent);
        finish();

    }
}