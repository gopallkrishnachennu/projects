package com.example.srmap.dashboard.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srmap.R;
import com.example.srmap.dashboard.Collaborate;
import com.example.srmap.dashboard.Helperclasses.User_collaborate;

import java.util.List;

public class Myadapter_collaborate extends RecyclerView.Adapter<Myadapter_collaborate.MyViewHolder> {

    String time1,time2;
    Context context;
    List<User_collaborate> user_collaborates;


    public Myadapter_collaborate(Collaborate collaborate, List<User_collaborate> list) {

        context=collaborate;
        user_collaborates=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.collaborate_design,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User_collaborate user=user_collaborates.get(position);
        time1=user.getTime().substring(0,5);
        time2=user.getTime().substring(6,11);
        holder.t1.setText(time1);
        holder.t3.setText(time2);
        Log.i("time",time1+time2);

        holder.t2.setText(user.getCourse());



    }

    @Override
    public int getItemCount() {
        return user_collaborates.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView t1,t2,t3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.time);
            t2=itemView.findViewById(R.id.course);
            t3=itemView.findViewById(R.id.time2);
        }
    }
}
