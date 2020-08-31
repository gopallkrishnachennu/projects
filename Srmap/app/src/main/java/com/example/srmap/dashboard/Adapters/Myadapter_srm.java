package com.example.srmap.dashboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srmap.R;
import com.example.srmap.dashboard.Helperclasses.Usersrm;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Myadapter_srm extends RecyclerView.Adapter<Myadapter_srm.MyViewHolder> {
    List<Usersrm> usersrmslist;
    Context ct;
    Usersrm usersrmdata;

    public Myadapter_srm(List<Usersrm> usersrms, Context context) {
        usersrmslist = usersrms;
        ct = context;

    }
    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(ct).inflate(R.layout.srm_recycler,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        usersrmdata=usersrmslist.get(position);
        holder.imageView.setImageResource(usersrmdata.getImages());
        holder.title.setText(usersrmdata.getTitle());
        holder.desc.setText(usersrmdata.getMaindescription());
        holder.secdesc.setText(usersrmdata.getSeconddescription());
        holder.stamp.setText(usersrmdata.getStamp());


    }

    @Override
    public int getItemCount() {
        return usersrmslist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,desc,secdesc,stamp;
        CircleImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.srmrecyclerimg);
            title=itemView.findViewById(R.id.titlerecycler);
            desc=itemView.findViewById(R.id.descriptionrecycler);
            secdesc=itemView.findViewById(R.id.seconddescription);
            stamp=itemView.findViewById(R.id.stamp);
        }
    }
}
