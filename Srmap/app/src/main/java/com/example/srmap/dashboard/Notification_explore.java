package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_academic;
import com.example.srmap.dashboard.Adapters.Myadapter_notification;
import com.example.srmap.dashboard.Helperclasses.User_itsupport;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Notification_explore extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    List<User_itsupport> user_itsupports;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_explore);
        recyclerView=findViewById(R.id.notificationrecycler);
        databaseReference= FirebaseDatabase.getInstance().getReference("Notification");
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
                Myadapter_notification myadapter_notification=new Myadapter_notification(user_itsupports,Notification_explore.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(Notification_explore.this));
                recyclerView.setAdapter(myadapter_notification);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}