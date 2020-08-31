package com.example.srmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgetpassword extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    TextView textView;
    Button button;
    Context ct;
    // firebase
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        imageView=findViewById(R.id.forgetimage);
        editText=findViewById(R.id.forgetemail);
        button=findViewById(R.id.sendlink);
        textView=findViewById(R.id.forgetlogin);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Forgetpassword.this, Login.class);
                startActivity(intent);
            }
        });
    }
    private boolean validEmail(){
        String email=editText.getText().toString().trim();
        if(email.isEmpty()){
            editText.setError("Field can't be empty");
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editText.setError("Please enter a valid SRM mail");
            return false;
        }
        if(!email.endsWith("@srmap.edu.in")){
            editText.setError("Valid only SRM Mail");
            return false;
        }
        else{
            editText.setError(null);
            return true;
        }
    }

    public void sendlink(View view) {
        if(!validEmail()){
            return;
        }else{
            firebaseAuth=FirebaseAuth.getInstance();
            firebaseAuth.sendPasswordResetEmail(editText.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Forgetpassword.this,"Reset link sent to your email",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(Forgetpassword.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }

                }
            });

        }


    }
}