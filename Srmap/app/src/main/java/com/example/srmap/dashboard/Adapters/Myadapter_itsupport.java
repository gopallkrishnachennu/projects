package com.example.srmap.dashboard.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srmap.R;
import com.example.srmap.dashboard.Helperclasses.User_collaborate;
import com.example.srmap.dashboard.Helperclasses.User_itsupport;
import com.example.srmap.dashboard.Helperclasses.Usercategory;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Myadapter_itsupport extends RecyclerView.Adapter<Myadapter_itsupport.MyViewHolder> {
    List<User_itsupport> user_itsupports;
    Context context;

    public Myadapter_itsupport(List<User_itsupport> user_itsupports, Context context) {
        this.user_itsupports = user_itsupports;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.it_design,parent,false);
        Myadapter_itsupport.MyViewHolder myViewHolder=new Myadapter_itsupport.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final User_itsupport user_itsupport=user_itsupports.get(position);
        holder.assignjob.setText(user_itsupport.getAssign());
        holder.email.setText(user_itsupport.getEmail());

        holder.nextbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i =holder.getAdapterPosition();
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+user_itsupports.get(i).getEmail()));
                //intent.putExtra(Intent.EXTRA_EMAIL,);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return user_itsupports.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  assignjob,email,number;
        ImageView nextbt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            assignjob=itemView.findViewById(R.id.jobrole);
            email=itemView.findViewById(R.id.mailaddress);
            nextbt=itemView.findViewById(R.id.next);


        }
    }
}
