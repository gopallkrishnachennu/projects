package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_category;
import com.example.srmap.dashboard.Helperclasses.Usercategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Category_home extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<Usercategory> usercategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_home);
        recyclerView=findViewById(R.id.categoryrecycler);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Hostel");

        usercategoryList=new ArrayList<>();



        loadrecycler();
    }

    private void loadrecycler() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usercategoryList.clear();
                recyclerView.setLayoutManager(new LinearLayoutManager(Category_home.this));

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Usercategory u=dataSnapshot.getValue(Usercategory.class);

                    usercategoryList.add(u);


                }

                Myadapter_category myadapter_category=new Myadapter_category(Category_home.this,usercategoryList);
                recyclerView.setAdapter(myadapter_category);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}