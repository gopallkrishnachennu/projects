package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import static com.example.navigation.R.id.collaborate;
import static com.example.navigation.R.id.home;
import static com.example.navigation.R.id.srm;
import static com.example.navigation.R.id.user;
import static com.example.navigation.R.id.vr;

public class Collaborate extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collaborate);

        chipNavigationBar=findViewById(R.id.chipnavigation);
        chipNavigationBar.setItemSelected(1,true);

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    case collaborate:
                        return;
                    case srm:
                        startActivity(new Intent(getApplicationContext(),Srm.class));
                        overridePendingTransition(0,0);
                        break;
                    case vr:
                        startActivity(new Intent(getApplicationContext(),Vr.class));
                        overridePendingTransition(0,0);
                        break;
                    case user:
                        startActivity(new Intent(getApplicationContext(),User.class));
                        overridePendingTransition(0,0);
                        break;

                }
            }
        });
    }
}