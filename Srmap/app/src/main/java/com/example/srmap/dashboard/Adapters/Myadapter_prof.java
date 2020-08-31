package com.example.srmap.dashboard.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srmap.Details;
import com.example.srmap.R;
import com.example.srmap.dashboard.Helperclasses.Userprof;
import com.example.srmap.dashboard.Professors;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Myadapter_prof extends RecyclerView.Adapter<Myadapter_prof.MyViewHolder> {
    List<Userprof> userprofs;
    Context context;
    Userprof userprof;

    public Myadapter_prof(Professors professors, List<Userprof> list) {
        context=professors;
        userprofs=list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.professor_design,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      userprof=userprofs.get(position);

        Picasso.get().load(userprof.getImages()).into(holder.circleImageView);
        holder.designtitle.setText(userprof.getName());
        holder.designdescription.setText(userprof.getDescription());
        holder.designseconddescription.setText(userprof.getSeconddescription());
        holder.designstamp.setText(userprof.getStamp());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(view.getContext(),Details.class);
                intent.putExtra("name",userprof.getName());
                intent.putExtra("desc",userprof.getDescription());
                intent.putExtra("sdesc",userprof.getSeconddescription());
                intent.putExtra("stamp",userprof.getStamp());
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return userprofs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView designtitle,designdescription,designstamp,designseconddescription;
        CircleImageView circleImageView;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView=itemView.findViewById(R.id.profimg);
            designtitle=itemView.findViewById(R.id.title);
            designdescription=itemView.findViewById(R.id.description);
            designseconddescription=itemView.findViewById(R.id.seconddescription);
            designstamp=itemView.findViewById(R.id.stamp);
            linearLayout=itemView.findViewById(R.id.profcard);

        }
    }
}
