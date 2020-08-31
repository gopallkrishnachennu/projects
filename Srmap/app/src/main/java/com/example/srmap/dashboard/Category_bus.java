package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_bus;
import com.example.srmap.dashboard.Adapters.Myadapter_category;
import com.example.srmap.dashboard.Helperclasses.Usercategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Category_bus extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<Usercategory> usercategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_bus);

        recyclerView =findViewById(R.id.busrecycler);
        usercategoryList=new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Bus");

        busdata();
    }

    private void busdata() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                recyclerView.setLayoutManager(new LinearLayoutManager(Category_bus.this));
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                   Usercategory u=dataSnapshot.getValue(Usercategory.class);
                   usercategoryList.add(u);

                }
                Myadapter_bus myadapter_bus=new Myadapter_bus(usercategoryList,Category_bus.this);
                recyclerView.setAdapter(myadapter_bus);


            }





            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}