package com.example.srmap.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.srmap.R;
import com.example.srmap.dashboard.Adapters.Myadapter_vr;
import com.example.srmap.dashboard.Helperclasses.Uservr;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class Vr extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    RecyclerView recyclerView;
    List<Uservr> uservrList;

    String girls="https://www.google.com/maps/@16.4649334,80.5077446,3a,90y,90t/data=!3m7!1e1!3m5!1sAF1QipPuANbFMJJgzYOZ2UklauGgvQMwiHTuQCaoUIkE!2e10!3e12!7i13000!8i6500";
    String boys="https://www.google.com/maps/@16.46485,80.5075602,3a,90y,335.39h,86.63t/data=!3m7!1e1!3m5!1sAF1QipPd9bnDNbUUp013dXi_xkcH_O-gEi11W99LpGn2!2e10!3e12!7i13000!8i6500";
    String vrreception="https://www.google.com/maps/@16.4647319,80.5078021,0a,52.4y,87.47h,89.53t/data=!3m4!1e1!3m2!1sAF1QipM7fSfLFkiC5HJ77pZ7pqDc7lvI0z0uBCkA6nkb!2e10?source=apiv3";
    String vrclassroom="https://www.google.com/maps/@16.4647367,80.507724,3a,52.4y,280.82h,88.93t/data=!3m7!1e1!3m5!1sAF1QipMb9FkS4bRxQNrZSIVxST5j-mTBcJ0w3dFhTuGH!2e10!3e12!7i13000!8i6500";
    String vrdigitalclassroom="https://www.google.com/maps/@16.4648885,80.507814,3a,52.4y,151.61h,86.62t/data=!3m7!1e1!3m5!1sAF1QipMOmJXMcIo87gnPGfz4ab92C9lR0y9s8XxI-0Fk!2e10!3e12!7i13000!8i6500";
    String vrdiscussion="https://www.google.com/maps/@16.4648867,80.5078565,3a,52.4y,286.12h,86.95t/data=!3m7!1e1!3m5!1sAF1QipNPokGD6VKKXuZjizfwIabESb_FeQfA3112zppf!2e10!3e12!7i13000!8i6500";
    String vrmeeting="https://www.google.com/maps/@16.4648856,80.5078631,3a,52.4y,175.43h,86.8t/data=!3m7!1e1!3m5!1sAF1QipOF5dQqB-RAV4AOlj-O3bj-rvl9ssjIAk8YTidY!2e10!3e12!7i13000!8i6500";
    String vrseminar="https://www.google.com/maps/@16.4649569,80.5079696,3a,52.4y,338.25h,85.48t/data=!3m7!1e1!3m5!1sAF1QipOHUPSlferVyy-po4o6TrwgqHoOLeUBx-bMWIcT!2e10!3e12!7i13000!8i6500";
    String vrlibrary="https://www.google.com/maps/@16.4649274,80.5078178,3a,52.4y,273.18h,91.73t/data=!3m7!1e1!3m5!1sAF1QipNx4AsAFKzdZ4r6ejMYT5KjWJm2TfbxPChDwk2m!2e10!3e12!7i13000!8i6500";
    String vrmusic="https://www.google.com/maps/@16.4649442,80.5077824,0a,52.4y,253.15h,83.12t/data=!3m4!1e1!3m2!1sAF1QipM2YbJF3moAW6XgwEWEMxFHDeegCaf0XbNGF7Dj!2e10?source=apiv3";
    String vrtabletennis="https://www.google.com/maps/@16.464875,80.5078037,0a,52.4y,182.45h,84t/data=!3m4!1e1!3m2!1sAF1QipN-KT3jC7MiTMxVlQpapaqw6CBWGhoQZAMkMpjL!2e10?source=apiv3";
    String vrrestaurant="https://www.google.com/maps/@16.4649511,80.5078339,3a,52.4y,90.89h,74.45t/data=!3m7!1e1!3m5!1sAF1QipM-Cf3YImGv482uG1W6KZ31D0G97unUbHZsC5vk!2e10!3e12!7i13000!8i6500";
    String vrcanteen="https://www.google.com/maps/@16.4648572,80.5077123,3a,21.3y,130.81h,70.62t/data=!3m7!1e1!3m5!1sAF1QipNINKRiFNHzCaCGuYEN64FNKmkxYP94Bj95pmj2!2e10!3e12!7i13000!8i6500";
    String vrmedical="https://www.google.com/maps/@16.4648352,80.5076634,3a,75y,10.61h,75.45t/data=!3m7!1e1!3m5!1sAF1QipOQmrg98y1L4JRXz5GLt-wJJfpyDS3C7czSgteg!2e10!3e12!7i13000!8i6500";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr);
        chipNavigationBar=findViewById(R.id.bottom_navigation);
        recyclerView=findViewById(R.id.vrrecycler);



        click();






      navigate();
    }

    private void click() {

        uservrList=new ArrayList<>();
        uservrList.add(new Uservr(R.drawable.reception,"Reception",vrreception));
        uservrList.add(new Uservr(R.drawable.labs_classrooms,"Classroom",vrclassroom));
        uservrList.add(new Uservr(R.drawable.digital_classroom,"Digita Clasroom",vrdigitalclassroom));
        uservrList.add(new Uservr(R.drawable.meeting_hall,"Meeting Hall",vrmeeting));
        uservrList.add(new Uservr(R.drawable.seminar,"Seminar",vrseminar));
        uservrList.add(new Uservr(R.drawable.discussion_room,"Discussion Room",vrdiscussion));
        uservrList.add(new Uservr(R.drawable.library,"Library",vrlibrary));
        uservrList.add(new Uservr(R.drawable.top_restaurant,"Restaurant",vrrestaurant));
        uservrList.add(new Uservr(R.drawable.canteen,"Canteen",vrcanteen));
        uservrList.add(new Uservr(R.drawable.view,"View",vrmedical));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Myadapter_vr myadapter_vr=new Myadapter_vr(uservrList,this);
        recyclerView.setAdapter(myadapter_vr);








    }

    private void navigate() {
        chipNavigationBar.setItemSelected(3,true);
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
                        startActivity(new Intent(getApplicationContext(),Srm.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.vr:
                        return;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        break;

                }
                finish();
            }
        });
    }
}