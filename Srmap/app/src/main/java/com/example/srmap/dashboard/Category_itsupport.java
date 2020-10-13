package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_itsupport;
import com.example.srmap.dashboard.Helperclasses.User_collaborate;
import com.example.srmap.dashboard.Helperclasses.User_itsupport;
import com.example.srmap.dashboard.Helperclasses.Usercategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Category_itsupport extends AppCompatActivity {

    RecyclerView recyclerView;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<User_itsupport> userItsupports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_itsupport);
        recyclerView=findViewById(R.id.itsupportrecycler);
        databaseReference=FirebaseDatabase.getInstance().getReference("It");




        data();


    }

    private void data() {
        userItsupports=new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userItsupports.clear();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    User_itsupport user_itsupportlist=dataSnapshot.getValue(User_itsupport.class);

                    userItsupports.add(user_itsupportlist);


                }
                Myadapter_itsupport myadapter_itsupport=new Myadapter_itsupport(userItsupports,Category_itsupport.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(Category_itsupport.this));
                recyclerView.setAdapter(myadapter_itsupport);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });


    }
}