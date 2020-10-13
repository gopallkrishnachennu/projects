package com.example.srmap.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.srmap.R;
import com.example.srmap.dashboard.Helperclasses.User_imageslider;
import com.example.srmap.dashboard.Helperclasses.Usercategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    ImageSlider imageSlider;
     List<SlideModel> slideModels;
     List<User_imageslider> user_imagesliders;
    //firebase
    LinearLayout lannouncement,lnews,lcampuslife,lcontact,labout,lhostel,lbus,lown;
    TextView announcement,news,campuslife,contact,about;

    String url;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chipNavigationBar=findViewById(R.id.bottom_navigation);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        imageSlider=findViewById(R.id.slideimage);
        // quick link text;
        announcement=findViewById(R.id.announcementmarquee);
        news=findViewById(R.id.newsmarquee);
        campuslife=findViewById(R.id.camuslifemarquee);
        contact=findViewById(R.id.contactmarquee);
        about=findViewById(R.id.aboutmarquee);
        //linear layout
        lannouncement=findViewById(R.id.announcements);
        lnews=findViewById(R.id.nenws);
        lcampuslife=findViewById(R.id.campuslife);
        lcontact=findViewById(R.id.contact);
        labout=findViewById(R.id.about);
        //explore things in srmap
        lhostel=findViewById(R.id.hostel);
        lbus=findViewById(R.id.bus);
        lown=findViewById(R.id.own);


        category();
        quicklinks();
        navigation();
        imageslide();

    }

    private void category() {
    lhostel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),Category_home.class);
            startActivity(intent);
        }
    });
    lbus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),Category_bus.class);
            startActivity(intent);

        }
    });
    lown.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),Category_own.class);
            startActivity(intent);

        }
    });



    }

    private void quicklinks() {
        databaseReference=firebaseDatabase.getReference("Quicklinks");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //announcement
                String dannouncement=snapshot.child("announcement").child("mtext").getValue().toString();
                final String dannounceurl=snapshot.child("announcement").child("url").getValue().toString();

                announcement.setText(dannouncement);
                announcement.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                announcement.setSelected(true);

                //intent
                lannouncement.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),Primewebview.class);
                        intent.putExtra("prime",dannounceurl);
                        startActivity(intent);
                    }
                });

                //news
                String dnews=snapshot.child("news").child("mtext").getValue().toString();
                final String dnewsurl=snapshot.child("news").child("url").getValue().toString();

                news.setText(dnews);
                news.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                news.setSelected(true);

                //intent
                lnews.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),Primewebview.class);
                        intent.putExtra("prime",dnewsurl);
                        startActivity(intent);
                    }
                });

                //campuslife
                String dcampuslife=snapshot.child("campuslife").child("mtext").getValue().toString();
                final String dcampusurl=snapshot.child("campuslife").child("url").getValue().toString();

                campuslife.setText(dcampuslife);
                campuslife.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                campuslife.setSelected(true);

                //intent
                lcampuslife.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),Primewebview.class);
                        intent.putExtra("prime",dcampusurl);
                        startActivity(intent);
                    }
                });

                //contact
                String dcontact=snapshot.child("contact").child("mtext").getValue().toString();
                final String dcontacturl=snapshot.child("contact").child("url").getValue().toString();

                contact.setText(dcontact);
                contact.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                contact.setSelected(true);

                //intent
                lcontact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),Primewebview.class);
                        intent.putExtra("prime",dcontacturl);
                        startActivity(intent);
                    }
                });

                //contact
                String dabout=snapshot.child("contact").child("mtext").getValue().toString();
                final String dabouturl=snapshot.child("contact").child("url").getValue().toString();

                about.setText(dabout);
                about.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                about.setSelected(true);

                //intent
                labout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),Primewebview.class);
                        intent.putExtra("prime",dabouturl);
                        startActivity(intent);
                    }
                });










            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void imageslide() {
       slideModels=new ArrayList<>();



        user_imagesliders=new ArrayList<>();




        FirebaseDatabase.getInstance().getReference("Imgslider").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                slideModels.clear();
                user_imagesliders.clear();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    final User_imageslider user_imageslider=dataSnapshot.getValue(User_imageslider.class);
                    user_imagesliders.add(user_imageslider);

                    String imgageurl=dataSnapshot.child("imgurl").getValue().toString();
                    String imagetitle=dataSnapshot.child("title").getValue().toString();

                    final String intenturl=dataSnapshot.child("go").getValue().toString();

                    slideModels.add(new SlideModel(imgageurl,imagetitle,ScaleTypes.FIT));
                    imageSlider.setImageList(slideModels,ScaleTypes.FIT);

                    imageSlider.setItemClickListener(new ItemClickListener() {
                        @Override
                        public void onItemSelected(int i) {

                            Intent intent=new Intent(getApplicationContext(),Primewebview.class);
                            intent.putExtra("prime",user_imagesliders.get(i).getGo());
                            startActivity(intent);

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void navigation() {
        chipNavigationBar.setItemSelected(0,true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.home:
                        return;
                    case R.id.collaborate:
                        startActivity(new Intent(getApplicationContext(),Collaborate.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.srm:
                        startActivity(new Intent(getApplicationContext(),Srm.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.vr:
                        startActivity(new Intent(getApplicationContext(),Vr.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        break;

                }
            }
        });
    }

    public void itsupport(View view) {
        Intent intent=new Intent(Home.this,Category_itsupport.class);
        startActivity(intent);

    }

    public void academic(View view) {
        Intent intent=new Intent(Home.this,Academic_explore.class);
        startActivity(intent);

    }

    public void notificationexplore(View view) {
        Intent intent=new Intent(Home.this,Notification_explore.class);
        startActivity(intent);


    }

    public void course(View view) {
        Intent intent=new Intent(Home.this,Course_explore.class);
        startActivity(intent);

    }

    public void homenotify(View view) {

        final AlertDialog.Builder builder=new AlertDialog.Builder(Home.this);
        View view1= LayoutInflater.from(getApplicationContext()).inflate(R.layout.home_info,null);
        TextView desc=view1.findViewById(R.id.homeitv);
        ImageView imageView=view1.findViewById(R.id.homeimg);

        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:srmapassistant@gmail.com"));
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_LONG).show();
            }
        });
        builder.setView(view1);
        final AlertDialog alertDialog=builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
}