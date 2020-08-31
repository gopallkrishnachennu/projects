package com.example.srmap.dashboard.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srmap.R;
import com.example.srmap.dashboard.Helperclasses.Uservr;
import com.example.srmap.dashboard.webview;

import java.util.List;

public class Myadapter_vr extends RecyclerView.Adapter<Myadapter_vr.MyViewHolder> {

    List<Uservr> userlist;
    Context context;
    Uservr uservrlist;

    public Myadapter_vr(List<Uservr> mylist, Context ct) {
        userlist = mylist;
        context =ct;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.vr_design,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        uservrlist=userlist.get(position);
        holder.imageView.setImageResource(uservrlist.getImage());
        holder.imagename.setText(uservrlist.getNames());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), webview.class);
                intent.putExtra("map",uservrlist.getUrl());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView imagename;
        ImageView imageView;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            imagename=itemView.findViewById(R.id.vrimgtxt);
            imageView=itemView.findViewById(R.id.vrimg);
            linearLayout=itemView.findViewById(R.id.vrlayout);



        }
    }
}
