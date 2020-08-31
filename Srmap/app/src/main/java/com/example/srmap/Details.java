package com.example.srmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Details extends AppCompatActivity {
    TextView name,desc,sdesc,stamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name=findViewById(R.id.detailname);
        desc=findViewById(R.id.detaildesc);
        sdesc=findViewById(R.id.detailseconddesc);
        stamp=findViewById(R.id.detailstamp);


        String Name=getIntent().getStringExtra("name");
        String Desc=getIntent().getStringExtra("desc");
        String Sdesc=getIntent().getStringExtra("sdesc");
        String Stamp=getIntent().getStringExtra("stamp");


        name.setText(Name);
        desc.setText(Desc);
        sdesc.setText(Sdesc);
        stamp.setText(Stamp);
    }
}