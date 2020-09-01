package com.example.srmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.srmap.dashboard.Profile;
import com.example.srmap.dashboard.Srm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity  implements FirebaseAuth.AuthStateListener {
     EditText username,password;
    ImageView imageView;

    TextView signuptv,forgettv;

    //firebase
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.lusername);
        password=findViewById(R.id.lpassword);
        imageView=findViewById(R.id.loginlogo);
        signuptv=findViewById(R.id.lsignup);
        forgettv=findViewById(R.id.forgetpassword);
        firebaseAuth=FirebaseAuth.getInstance();
        // direct login




    }

    @Override
    public void onBackPressed() {


    }

    @Override
    protected void onStart() {
        super.onStart();
       firebaseAuth.addAuthStateListener(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(this);
    }

    //valid email
    private boolean validEmail(){
        String email=username.getText().toString().trim();
        if(email.isEmpty()){
            username.setError("Field can't be empty");
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            username.setError("Please enter a valid SRM mail");
            return false;
        }
        if(!email.endsWith("@srmap.edu.in")){
            username.setError("Valid only SRM Mail");
            return false;
        }
        else{
            username.setError(null);
            return true;
        }
    }
    //valid password
    private boolean validPassword(){
        String pass=password.getText().toString().trim();
        if (pass.isEmpty()){
            password.setError("Field can't be empty");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }
    }


//going to dashboard
    public void lsignin(View view) {
        if(!validEmail() | !validPassword()){
            return;
        }
        else{

            firebaseAuth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        if ( firebaseAuth.getCurrentUser().isEmailVerified()){
                            Toast.makeText(Login.this,"Dashboard",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(Login.this, Srm.class);
                            String loginemail =username.getText().toString().trim();
                            intent.putExtra("email",loginemail);
                            overridePendingTransition(0,0);
                            startActivity(intent);


                        }
                        else {
                            Toast.makeText(Login.this,"Verify your SRM Email",Toast.LENGTH_LONG).show();

                        }

                    }else{
                        Toast.makeText(Login.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                    }

                }
            });




        }


    }



    //going to register page
    public void lsignup(View view) {
        Intent intent=new Intent(Login.this, Register.class);
        startActivity(intent);
        Toast.makeText(Login.this,"Register",Toast.LENGTH_LONG).show();
    }

    //forget password page
    public void forgetpassword(View view) {
        Intent intent= new Intent(Login.this, Forgetpassword.class);
        startActivity(intent);

    }


    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if (firebaseAuth.getCurrentUser()!=null && firebaseAuth.getCurrentUser().isEmailVerified() ){
            Intent intent=new Intent(getApplicationContext(),Srm.class);
            overridePendingTransition(0,0);
            startActivity(intent);
        }
    }
}