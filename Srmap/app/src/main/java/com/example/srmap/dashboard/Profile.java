package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.srmap.Login;
import com.example.srmap.R;
import com.example.srmap.Registerdetails;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FirebaseUser firebaseUser;
    TextView name;
    TextInputEditText mail,phonenumber,fname,lname,useridno;
    FirebaseAuth firebaseAuth;
    String email;
    //databese details
    String dfname,dlname,dnumber,did;
    List<Registerdetails> registerdetailed;
    Registerdetails registerdetails;

    public static final String sharedname="gopal";
    public static final String text="text";


    // signout
    ImageView signout;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mail =findViewById(R.id.profilemail);
        fname =findViewById(R.id.firstname);
        lname =findViewById(R.id.lastname);
        name=findViewById(R.id.profilename);
        useridno=findViewById(R.id.userid);
        phonenumber =findViewById(R.id.profilenumber);
        chipNavigationBar=findViewById(R.id.bottom_navigation);
        firebaseAuth=FirebaseAuth.getInstance();
        registerdetailed=new ArrayList<>();

        signout=findViewById(R.id.signout);
        dataretrive();

        //signout


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Profile.this);
                View view1= LayoutInflater.from(Profile.this).inflate(R.layout.signout_dialogbox,null);
                TextView textView=view1.findViewById(R.id.signoutmain);
                TextView textView1=view1.findViewById(R.id.signouttext);
                builder.setPositiveButton("Sign out", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        firebaseAuth.getInstance().signOut();
                        Toast.makeText(getApplicationContext(),"Sign Out",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setView(view1);
                AlertDialog alertDialog=builder.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();


            }
        });
        signoutbutton();


        //firebase

       if (firebaseAuth.getCurrentUser()!=null){

           firebaseUser= firebaseAuth.getCurrentUser();

            email= firebaseUser.getEmail();

           mail.setText(email);



       }
       else{
           Toast.makeText(Profile.this,"error",Toast.LENGTH_LONG).show();
       }

        navigate();

    }

    private void dataretrive() {
        databaseReference= FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    registerdetails=dataSnapshot.getValue(Registerdetails.class);

                    registerdetailed.add(registerdetails);
                    if (email.equals(registerdetails.getEmail())){

                        dfname=registerdetails.getName();
                        dlname=registerdetails.getLastname();
                        dnumber=registerdetails.getPhoneno();
                        did=registerdetails.getId();


                        fname.setText(dfname);
                        lname.setText(dlname);
                        phonenumber.setText(dnumber);
                        useridno.setText(did);


                        name.setText(registerdetails.getName());

//                        SharedPreferences sharedPreferences=getSharedPreferences(sharedname,MODE_PRIVATE);
//                        SharedPreferences.Editor editor=sharedPreferences.edit();
//                        editor.putString(text,registerdetails.getName());
//                        editor.apply();

                    }



                    Log.i("data",email+" "+registerdetails.getEmail());


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Profile.this,error.getMessage()+"errordetails",Toast.LENGTH_LONG).show();
            }
        });


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

    public void updatedialog(View view) {
        databaseReference= FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    registerdetails=dataSnapshot.getValue(Registerdetails.class);

                    registerdetailed.add(registerdetails);
                    if (email.equals(registerdetails.getEmail())){

//                        dfname=registerdetails.getName();
//                      dlname=registerdetails.getLastname();
//                        dnumber=registerdetails.getPhoneno();

                        String firstname=fname.getText().toString();
                        String lastname=lname.getText().toString();
                        String num=phonenumber.getText().toString();

                        databaseReference.child(did).child("name").setValue(firstname);
                        databaseReference.child(did).child("lastname").setValue(lastname);
                        databaseReference.child(did).child("phoneno").setValue(num);
                        dataretrive();
                    }
                    Log.i("data",email+" "+registerdetails.getEmail());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Profile.this,error.getMessage()+"errordetails",Toast.LENGTH_LONG).show();
            }
        });


    }


    public void backbutton(View view) {
        onBackPressed();
    }

    public void profilepic(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(Profile.this);
        View view1= LayoutInflater.from(Profile.this).inflate(R.layout.profile_privacy,null);

        TextView textView=view1.findViewById(R.id.privacy);
        TextView textView1=view1.findViewById(R.id.privacydesc);
        TextView textView2=view1.findViewById(R.id.privacybutton);
        ImageView imageView=view1.findViewById(R.id.privacyimage);

        builder.setView(view1);
        final AlertDialog alertDialog=builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


    }
}