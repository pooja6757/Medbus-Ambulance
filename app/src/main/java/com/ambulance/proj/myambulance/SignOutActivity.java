package com.ambulance.proj.myambulance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignOutActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth fAuth;

    //view objects
    private TextView DispUserEmail;
    private Button UserLogOut,userProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);

        //initializing firebase authentication object
        fAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if (fAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, DriverLogin.class));
        }

        //getting current user
        FirebaseUser user = fAuth.getCurrentUser();

        //initializing views
        DispUserEmail = (TextView) findViewById(R.id.showEmail);
        UserLogOut = (Button) findViewById(R.id.bLogOut);
        userProfile=(Button)findViewById(R.id.bprofile);

        //displaying logged in user name
        DispUserEmail.setText("Welcome " + user.getEmail());

        //adding listener to button
        UserLogOut.setOnClickListener(this);
        userProfile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if (view ==   UserLogOut) {
            //logging out the user
            fAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, DriverLogin.class));
        }
        if(view==userProfile)
        {
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }
}
