package com.example.srmap.dashboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srmap.R;
import com.example.srmap.dashboard.Category_home;
import com.example.srmap.dashboard.Helperclasses.Usercategory;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Myadapter_category extends RecyclerView.Adapter<Myadapter_category.MyViewHolder> {
    List<Usercategory> usercategories;
    Context context;

    public Myadapter_category(Category_home category_home, List<Usercategory> usercategories) {
        this.usercategories = usercategories;
        context=category_home;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.category_design,parent,false);
       MyViewHolder myViewHolder=new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Usercategory usercategory=usercategories.get(position);
        holder.job.setText(usercategory.getJob());
        holder.name.setText(usercategory.getName());
        holder.assign.setText(usercategory.getAssign());
        holder.phone.setText(usercategory.getPhone()+"");
        holder.email.setText(usercategory.getEmail());
        Picasso.get().load(usercategory.getImage()).into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return usercategories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView job,assign,name,phone,email;
        CircleImageView circleImageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            job=itemView.findViewById(R.id.categoryjob);
            assign=itemView.findViewById(R.id.categoryassign);
            name=itemView.findViewById(R.id.categoryname);
            phone=itemView.findViewById(R.id.categoryphone);
            email=itemView.findViewById(R.id.categoryemail);
            circleImageView=itemView.findViewById(R.id.categoryimage);
        }
    }
}
