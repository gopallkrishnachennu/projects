package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_academic;
import com.example.srmap.dashboard.Adapters.Myadapter_itsupport;
import com.example.srmap.dashboard.Helperclasses.User_itsupport;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Academic_explore extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    List<User_itsupport> user_itsupports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_explore);
        recyclerView=findViewById(R.id.academicrecycler);
        databaseReference= FirebaseDatabase.getInstance().getReference("Academic");
        user_itsupports=new ArrayList<>();
        data();
    }

    private void data() {

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user_itsupports.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    User_itsupport user_itsupport=dataSnapshot.getValue(User_itsupport.class);
                    user_itsupports.add(user_itsupport);
                }
                Myadapter_academic myadapter_academic=new Myadapter_academic(user_itsupports,Academic_explore.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(Academic_explore.this));
                recyclerView.setAdapter(myadapter_academic);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}