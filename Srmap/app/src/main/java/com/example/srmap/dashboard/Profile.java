package com.example.srmap.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.srmap.Login;
import com.example.srmap.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Profile extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FirebaseUser firebaseUser;
    TextInputEditText textInputEditText,phonenumber;
    FirebaseAuth firebaseAuth;
    // signout
    ImageView signout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textInputEditText =findViewById(R.id.profilemail);
        phonenumber =findViewById(R.id.profilenumber);
        chipNavigationBar=findViewById(R.id.bottom_navigation);
        firebaseAuth=FirebaseAuth.getInstance();
        signout=findViewById(R.id.signout);
        //signout


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(),"Sign Out",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);




            }
        });
        signoutbutton();


        //firebase

       if (firebaseAuth.getCurrentUser()!=null){
           firebaseUser= firebaseAuth.getCurrentUser();
           String email= firebaseUser.getEmail();
           String phone= firebaseUser.getPhoneNumber();

           textInputEditText.setText(email);
           phonenumber.setText(phone);
       }
       else{
           Toast.makeText(Profile.this,"error",Toast.LENGTH_LONG).show();
       }

        navigate();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void signoutbutton() {

    }

    private void navigate() {
        chipNavigationBar.setItemSelected(4,true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.collaborate:
                        startActivity(new Intent(getApplicationContext(),Collaborate.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.srm:
                        startActivity(new Intent(getApplicationContext(), Srm.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.vr:
                        startActivity(new Intent(getApplicationContext(),Vr.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.profile:
                        return;

                }
            }
        });
    }
}