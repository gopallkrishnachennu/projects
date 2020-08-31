package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import static com.example.navigation.R.id.collaborate;
import static com.example.navigation.R.id.home;
import static com.example.navigation.R.id.info;
import static com.example.navigation.R.id.src_atop;
import static com.example.navigation.R.id.srm;
import static com.example.navigation.R.id.user;
import static com.example.navigation.R.id.vr;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chipNavigationBar=findViewById(R.id.chipnavigation);
        chipNavigationBar.setItemSelected(0,true);

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case home:
                        return;
                    case collaborate:
                        startActivity(new Intent(getApplicationContext(),Collaborate.class));
                        overridePendingTransition(0,0);
                        break;
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