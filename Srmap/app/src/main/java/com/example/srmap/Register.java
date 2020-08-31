package com.example.srmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    Context ct;
    TextView textView;
    TextInputEditText Name,Lastname,Email,Phone,Password,Cpassword;
    private static final Pattern PASSWORD_PATTERN=Pattern.compile( "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{6,20}$" );
    ProgressDialog progressDialog;
    //firebase

    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name=findViewById(R.id.name);
        Lastname=findViewById(R.id.lastname);
        Email=findViewById(R.id.email);
        Phone=findViewById(R.id.phone);
        Password=findViewById(R.id.password);
        Cpassword=findViewById(R.id.confirmpassword);
        textView=findViewById(R.id.signin);


        progressDialog=new ProgressDialog(Register.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Loading...");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ct, Login.class);
                startActivity(intent);
            }
        });
    }

    private boolean validName(){
        String name=Name.getText().toString().trim();
        if(name.isEmpty()){
            Name.setError("Field can't be empty");
            return false;
        }else {
            Name.setError(null);
            return true;
        }
    }

    private boolean validLastname(){
        String lastname=Lastname.getText().toString().trim();
        if(lastname.isEmpty()){
            Lastname.setError("Field cant't be empty");
            return false;
        }
        else {
            Lastname.setError(null);
            return true;
        }
    }

    private boolean validEmail(){
        String email=Email.getText().toString().trim();
        if(email.isEmpty()){
            Email.setError("Field can't be empty");
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Please enter a valid SRM mail");
            return false;
        }
        if(!email.endsWith("@srmap.edu.in")){
            Email.setError("Valid only SRM Mail");
            return false;
        }
        else{
            Email.setError(null);
            return true;
        }
    }

    private boolean validPhone(){
        String phone=Phone.getText().toString().trim();
        if(phone.isEmpty()){
            Phone.setError("Field cant't be empty");
            return false;
        }
        else if(phone.length()>10){
            Phone.setError("Invalid Number !");
            return false;
        }
        else {
            Phone.setError(null);
            return true;
        }
    }

    private boolean validPassword(){
        String password=Password.getText().toString().trim();
        if (password.isEmpty()){
            Password.setError("Field can't be empty");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(password).matches()){
            Password.setError("Password too weak");
            return false;
        }
        else {
            Password.setError(null);
            return true;
        }
    }
    private boolean validcpassword(){
        String password=Password.getText().toString().trim();
        String cpassword=Cpassword.getText().toString().trim();
        if (cpassword.isEmpty()){
            Cpassword.setError("Password doesn't match");
            return false;
        }
        else if(!cpassword.equals(password)){
            Cpassword.setError("Password do not match");
            return false;

        }
        else {
            Cpassword.setError(null);
            return true;
        }
    }

    public void signup(View view) {


        if(!validName() | !validLastname() | !validEmail() | !validPhone() |!validPassword() |! validcpassword()){
            return;
        }
        else {
            progressDialog.show();
            rootnode=FirebaseDatabase.getInstance();
            reference=rootnode.getReference("users");
            firebaseAuth=FirebaseAuth.getInstance();

            firebaseAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful()){
                        firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(Register.this,"Registered successfully,Verify your Email",Toast.LENGTH_LONG).show();
                                    String name=Name.getText().toString().trim();
                                    String lastname=Lastname.getText().toString().trim();
                                    String email=Email.getText().toString().trim();
                                    String phoneno=Phone.getText().toString().trim();
                                    String password=Password.getText().toString().trim();
                                    Registerdetails registerdetails=new Registerdetails(name,lastname,email,phoneno,password);
                                    reference.child(lastname).setValue(registerdetails);
                                    startActivity(new Intent(Register.this,Login.class));
                                    finish();

                                }else {
                                    Toast.makeText(Register.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                                }
                            }
                        });
                    }else {
                        Toast.makeText(Register.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                    }

                }
            });





        }

    }

    //text view to go to login page

    public void rsign(View view) {
        finish();
        overridePendingTransition(0,0);
        Intent intent=new Intent(Register.this,Login.class);
        startActivity(intent);

    }
}