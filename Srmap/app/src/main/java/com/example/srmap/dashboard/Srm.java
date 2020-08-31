package com.example.srmap.dashboard;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_srm;
import com.example.srmap.dashboard.Helperclasses.Usersrm;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class Srm extends AppCompatActivity {
    ImageView imageView;
    TextView marquee;

    ChipNavigationBar chipNavigationBar;
    List<Usersrm> list;
    Context ct;
    ListView listView;
    RelativeLayout assignmentcard,modelpapercard,notescard,gpacalculatorcard;
    LinearLayout  nexttechlab,ennovablab,acmlab,hackathonlab,admin,student,edx,ecloud,parent,lear,cdc,ccc,professor;
    //.......proffesor list..........

    //......official sites..........
    String studenturl="https://student.srmap.edu.in/srmapstudentcorner/StudentLoginPage";
    String edxurl="https://edge.edx.org/login";
    String ecloudurl="https://examcloud.in/epn/slogin.php";
    String parenturl="https://parent.srmap.edu.in/srmapparentcorner/LoginPage";
    String learnxturl="http://learnxt.gpeducation.org/login/index.php";
    String cdcurl="http://empower.srmist.edu.in/login/index.php";
    String cccurl="https://icode.ccc.training/login";

    //........prime...urls....
    String assignmenturl="https://classroom.google.com/";
    String modalpaperurl="https://drive.google.com/drive/folders/1T_ZW2aYE-G8RU8fHTJmbM27anzQ_hKiC?usp=sharing";
    String notesurl="https://drive.google.com/drive/folders/1ZCcevrsYF0CSJRMbrg0FzNsQqfiVdPJn?usp=sharing";
    String gpacalculatorurl="https://optimusam.github.io/srmgpa/";

    //........more ......urls.....
    String nexttechurl="https://srmap.edu.in/next-tech-lab%e2%80%a8-2/";
    String ennovabyrl="https://srmap.edu.in/ennovab/";
    String acmurl="https://srmap.acm.org/index.html";
    String hackathonurl="https://srmap.edu.in/tech-festhackathon/";



    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srm);
        //.......firebase....
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

        //..............bottomsheet...........

        chipNavigationBar=findViewById(R.id.bottom_navigation);
        //..recycler
        recyclerView=findViewById(R.id.srmcardrecycler);
        //..........trending.....
        marquee=findViewById(R.id.marquee);
        //....prime.......
        assignmentcard=findViewById(R.id.assignment);
        modelpapercard=findViewById(R.id.modelpaper);
        notescard=findViewById(R.id.notes);
        gpacalculatorcard=findViewById(R.id.gpacalculator);
        //......more.......
        nexttechlab=findViewById(R.id.nexttech);
        ennovablab=findViewById(R.id.ennovab);
        acmlab=findViewById(R.id.acm);
        hackathonlab=findViewById(R.id.hackathon);
        admin=findViewById(R.id.admins);
        //....officialsites....
        student=findViewById(R.id.studentportal);
        edx=findViewById(R.id.edxportal);
        ecloud=findViewById(R.id.examcloudportal);
        parent=findViewById(R.id.parentportal);
        lear=findViewById(R.id.learnxt);
        cdc=findViewById(R.id.cdcempower);
        ccc=findViewById(R.id.iccc);
        //.......professor.....
        professor=findViewById(R.id.professor);

        prof();
        officialsites();
        primelistclick();
        marqueetext();
        recyclerview();
        navigate();
        more();


    }



    private void prof() {
        professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Srm.this,Professors.class);
                startActivity(intent);
            }
        });
    }

    private void officialsites() {
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW , Uri.parse(studenturl));
                startActivity(intent);


            }
        });
        edx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW , Uri.parse(edxurl));
                startActivity(intent);


            }
        });
        ecloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW , Uri.parse(ecloudurl));
                startActivity(intent);

            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW , Uri.parse(parenturl));
                startActivity(intent);


            }
        });
        lear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW , Uri.parse(learnxturl));
                startActivity(intent);


            }
        });
        cdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW , Uri.parse(cdcurl));
                startActivity(intent);


            }
        });
        ccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW , Uri.parse(cccurl));
                startActivity(intent);


            }
        });

    }


    //..........more.........

    private void more() {
        nexttechlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Primewebview.class);
                intent.putExtra("prime",nexttechurl);
                startActivity(intent);
                finish();

            }
        });
        ennovablab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Primewebview.class);
                intent.putExtra("prime",ennovabyrl);
                startActivity(intent);
                finish();

            }
        });
        acmlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Primewebview.class);
                intent.putExtra("prime",acmurl);
                startActivity(intent);
                finish();

            }
        });
        hackathonlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Primewebview.class);
                intent.putExtra("prime",hackathonurl);
                startActivity(intent);
                finish();

            }
        });


        //........admins.....

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Admin.class);
                startActivity(intent);
                finish();

            }
        });



    }

    //.......prime...............

    private void primelistclick() {
        notescard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Primewebview.class);
                intent.putExtra("prime",notesurl);
                startActivity(intent);
                finish();

            }
        });

        assignmentcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Primewebview.class);
                intent.putExtra("prime",assignmenturl);
                startActivity(intent);
                finish();

            }
        });

        modelpapercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Primewebview.class);
                intent.putExtra("prime",modalpaperurl);
                startActivity(intent);
                finish();

            }
        });

        gpacalculatorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Srm.this,Primewebview.class);
                intent.putExtra("prime",gpacalculatorurl);
                startActivity(intent);
                finish();

            }
        });


    }
//.............trending.........


    private void marqueetext() {


        databaseReference=firebaseDatabase.getReference("Trending").child("Feed");
        databaseReference.setValue("SRM AP launched for our graduates to provide for educational uses ....Support it and share");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference=firebaseDatabase.getReference("Trending").child("Feed");
                String text=snapshot.getValue().toString();
                marquee.setText(text);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        marquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        marquee.setSelected(true);
    }




    private void recyclerview() {

        list=new ArrayList<>();
        list.add(new Usersrm(R.drawable.boys_hostel,"Srm University","HI im gopala krishna","this is graduate","#Dia"));
        list.add(new Usersrm(R.drawable.canteen,"Srm University","HI im gopala krishna","this is graduate","#Dia"));
        list.add(new Usersrm(R.drawable.labs_classrooms,"Srm University","HI im gopala krishna","this is graduate","#Dia"));
        list.add(new Usersrm(R.drawable.view,"Srm University","HI im gopala krishna","this is graduate","#Dia"));
        list.add(new Usersrm(R.drawable.girls_hostel,"Srm University","HI im gopala krishna","this is graduate","#Dia"));
        list.add(new Usersrm(R.drawable.meeting_hall,"Srm University","HI im gopala krishna","this is graduate","#Dia"));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false));

        Myadapter_srm myadapter_srm=new Myadapter_srm(list,this);
        recyclerView.setAdapter(myadapter_srm);




    }

    private void navigate() {
        chipNavigationBar.setItemSelected(2,true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.collaborate:
                        startActivity(new Intent(getApplicationContext(),Collaborate.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.srm:
                        return;
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


}