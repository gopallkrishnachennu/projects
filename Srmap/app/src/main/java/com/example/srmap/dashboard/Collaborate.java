package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_collaborate;
import com.example.srmap.dashboard.Helperclasses.User_collaborate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Collaborate extends AppCompatActivity {

    RecyclerView r;
   public   String sptext;
    FirebaseDatabase database;
    DatabaseReference reference;
    List<User_collaborate> list;
    String course,day="",section,total,year;
    int hours,minutes;
   Spinner dy,dc,ds;
    Button b;

    public static final  String SHARED_PRE="d";
    public  static final String TEXT="s";




    String harish;


    ChipNavigationBar chipNavigationBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collaborate);
        chipNavigationBar=findViewById(R.id.bottom_navigation);
        chipNavigationBar.setItemSelected(1,true);

        list=new ArrayList<>();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        r=findViewById(R.id.recycler);
        b=findViewById(R.id.liv);


        loaddata();
        harish=sptext;
        Calendar ca=Calendar.getInstance();
        int dayofWeek=ca.get(Calendar.DAY_OF_WEEK);
        if(dayofWeek==Calendar.MONDAY)day="monday";
        if(dayofWeek==Calendar.TUESDAY)day="tuesday";
        if(dayofWeek==Calendar.WEDNESDAY)day="wednesday";
        if(dayofWeek==Calendar.THURSDAY)day="thursady";
        if(dayofWeek==Calendar.FRIDAY)day="friday";
        if(dayofWeek==Calendar.SATURDAY)day="saturday";
        if (dayofWeek==Calendar.SUNDAY)day="monday";
        submission();


        //navigation


        navigation();





    }
    public  void  savadata(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PRE,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(TEXT,harish);
        editor.apply();

    }

    public void loaddata(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PRE,MODE_PRIVATE);
        sptext=sharedPreferences.getString(TEXT,"");


    }

    private void navigation() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.collaborate:
                        return;
                    case R.id.srm:
                        startActivity(new Intent(getApplicationContext(),Srm.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.vr:
                        startActivity(new Intent(getApplicationContext(),Vr.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        break;

                }
            }
        });
    }


    public void today(View view) {
        Calendar ca=Calendar.getInstance();

        int dayofWeek=ca.get(Calendar.DAY_OF_WEEK);
        if (dayofWeek==Calendar.SUNDAY)day="monday";
        if(dayofWeek==Calendar.MONDAY)day="monday";
        if(dayofWeek==Calendar.TUESDAY)day="tuesday";
        if(dayofWeek==Calendar.WEDNESDAY)day="wednesday";
        if(dayofWeek==Calendar.THURSDAY)day="thursady";
        if(dayofWeek==Calendar.FRIDAY)day="friday";
        if(dayofWeek==Calendar.SATURDAY)day="saturday";

        submission();
    }

    public void monday(View view) {

        day="monday";

        submission();
    }

    public void tuesday(View view) {

        day="tuesday";
        submission();
    }

    public void wednesday(View view) {

        day="wednesday";
        submission();
    }

    public void thursday(View view) {

        day="thursday";
        submission();
    }

    public void friday(View view) {

        day="friday";
        submission();
    }

    public void saturday(View view) {
        day="";
        day="saturday";
        submission();
    }

    public void live(View view) {

    }

    public void dialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(Collaborate.this);
        View v=getLayoutInflater().inflate(R.layout.dialogbox_category,null);
        dy=(Spinner) v.findViewById(R.id.y);
        dc=(Spinner) v.findViewById(R.id.s);
        ds=(Spinner) v.findViewById(R.id.c);
        builder.setTitle("Collaberate");
        ArrayAdapter<CharSequence> course_data = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        dy.setAdapter(course_data);
        dy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        ArrayAdapter<CharSequence> section_data1 = ArrayAdapter.createFromResource(Collaborate.this, R.array.course, android.R.layout.simple_spinner_item);
                        dc.setAdapter(section_data1);
                        dc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                switch(i)
                                {
                                    case 0:
                                        ArrayAdapter<CharSequence> arr=ArrayAdapter.createFromResource(Collaborate.this,R.array.computer_science2,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr);
                                        break;
                                    case 1:
                                        ArrayAdapter<CharSequence> arr1=ArrayAdapter.createFromResource(Collaborate.this,R.array.civil,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr1);
                                        break;
                                    case 2:
                                        ArrayAdapter<CharSequence> arr2=ArrayAdapter.createFromResource(Collaborate.this,R.array.electrical_electronics,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr2);
                                        break;
                                    case 3:
                                        ArrayAdapter<CharSequence> arr3=ArrayAdapter.createFromResource(Collaborate.this,R.array.electronics_communication2,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr3);
                                        break;
                                    case 4:
                                        ArrayAdapter<CharSequence> arr4=ArrayAdapter.createFromResource(Collaborate.this,R.array.mechanical,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr4);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        break;
                    case 1:
                        ArrayAdapter<CharSequence> section_data = ArrayAdapter.createFromResource(Collaborate.this, R.array.course, android.R.layout.simple_spinner_item);
                        dc.setAdapter(section_data);
                        dc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                switch(i)
                                {
                                    case 0:
                                        ArrayAdapter<CharSequence> arr=ArrayAdapter.createFromResource(Collaborate.this,R.array.computer_science3,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr);
                                        break;
                                    case 1:
                                        ArrayAdapter<CharSequence> arr1=ArrayAdapter.createFromResource(Collaborate.this,R.array.civil,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr1);
                                        break;
                                    case 2:
                                        ArrayAdapter<CharSequence> arr2=ArrayAdapter.createFromResource(Collaborate.this,R.array.electrical_electronics,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr2);
                                        break;
                                    case 3:
                                        ArrayAdapter<CharSequence> arr3=ArrayAdapter.createFromResource(Collaborate.this,R.array.electronics_communication3,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr3);
                                        break;
                                    case 4:
                                        ArrayAdapter<CharSequence> arr4=ArrayAdapter.createFromResource(Collaborate.this,R.array.mechanical,android.R.layout.simple_spinner_item);
                                        ds.setAdapter(arr4);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                year=dy.getSelectedItem().toString();
                course=ds.getSelectedItem().toString();
                section=dc.getSelectedItem().toString();
                harish="/"+year+"/"+section+"/"+course+"/";
                savadata();
                submission();

            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Collaborate.this, "unsucessful", Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        builder.setView(v);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void submission() {

        list.clear();

        total=harish+day;



        Log.i("data",total);
        reference.child(total).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                r.setLayoutManager(new LinearLayoutManager(Collaborate.this));
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    User_collaborate user_collaborate=dataSnapshot.getValue(User_collaborate.class);
                    list.add(user_collaborate);

                }
               Myadapter_collaborate myadapter_collaborate=new Myadapter_collaborate(Collaborate.this,list);
                r.setAdapter(myadapter_collaborate);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}