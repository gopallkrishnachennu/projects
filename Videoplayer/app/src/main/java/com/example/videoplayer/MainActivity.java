package com.example.videoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    File directory;
    public static int REQUEST_PERMISSION=1;
    Boolean aBoolean;
    public  static List<File> list=new ArrayList<>();
    Myadapter obj_Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);

        directory=new File("/mnt/");


        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);


        videopermission();

    }

    private void videopermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){


        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){

        }
        else{
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}
            ,REQUEST_PERMISSION);
        }

        }else {
            aBoolean=true;
            getFile(directory);
            obj_Adapter=new Myadapter(MainActivity.this,list);
            recyclerView.setAdapter(obj_Adapter);


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==REQUEST_PERMISSION){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                aBoolean=true;
                getFile(directory);
                obj_Adapter=new Myadapter(MainActivity.this,list);
                recyclerView.setAdapter(obj_Adapter);
            }else {
                Toast.makeText(MainActivity.this,"Allow the permission",Toast.LENGTH_LONG).show();
            }
        }
    }

   public List<File> getFile(File directory){

        File listfile[]=directory.listFiles();
        if (listfile!=null && listfile.length>0){
            for (int i=0;i<listfile.length;i++){
                if (listfile[i].isDirectory()){
                    getFile(listfile[i]);

                }
                else {
                    aBoolean=false;
                    if (listfile[i].getName().endsWith(".mp4")){
                        for (int j=0;j<list.size();j++){
                            if (list.get(j).getName().equals(listfile[i].getName())){
                                aBoolean=true;
                            }
                            else {
                                list.add(listfile[i]);

                            }
                        }
                    }
                }
            }
        }
        return list;
   }




}