package com.ambulance.proj.myambulance;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DriverInfo extends AppCompatActivity {
    String ambType="basic";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_info);


    }

    public void basicLogin(View v)
    {
        if(ambType.equals("basic"))
        {
            FirebaseAuth firebaseAuth;
            firebaseAuth = FirebaseAuth.getInstance();
            String userName="pooja.rupanwar5767@gmail.com";
            String userPassword="8208853082";
            firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {

                        // Toast.makeText(SelectAmb.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        //basicLogin();
                        Intent i =new Intent(DriverInfo.this,BasicSignIn.class);
                        startActivity(i);
                        //checkEmailVerification();
                    }else{
                        Toast.makeText(DriverInfo.this, "error occured", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
