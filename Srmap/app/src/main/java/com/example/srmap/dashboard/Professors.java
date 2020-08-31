package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_prof;
import com.example.srmap.dashboard.Helperclasses.Userprof;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Professors extends AppCompatActivity {
    EditText title,desc,stamp,searchView;
    Button button;
    List<Userprof> list;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private Myadapter_prof  myadapter_prof;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professors);

        //proffessor recycler
        recyclerView=findViewById(R.id.proffrecycler);
        list=new ArrayList<>();

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Proff");
        load();


    }

    private void load() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Userprof u= dataSnapshot.getValue(Userprof.class);
                    list.add(u);

                }
               Myadapter_prof myadapter_prof=new Myadapter_prof(Professors.this,list);
                recyclerView.setLayoutManager(new LinearLayoutManager(Professors.this));
                recyclerView.setAdapter(myadapter_prof);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });




    }






}