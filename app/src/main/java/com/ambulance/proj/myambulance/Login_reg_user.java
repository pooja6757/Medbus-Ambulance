package com.ambulance.proj.myambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login_reg_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg_user);
    }

    public void userLoginClick(View v)
    {
        Intent i=new Intent(Login_reg_user.this, LoginOtp.class);
        startActivity(i);
    }
    public void userRegClick(View v)
    {
        Intent i=new Intent(Login_reg_user.this, OtpActivity.class);
        startActivity(i);
    }
}
