package com.ambulance.proj.myambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login_reg_driver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg_driver);
    }
    public void clickLogin(View v)
    {
        Intent i=new Intent(Login_reg_driver.this, DriverLogin.class);
        startActivity(i);
    }
    public void clickReg(View v)
    {
        Intent i=new Intent(Login_reg_driver.this, RegistrationActivity.class);
        startActivity(i);
    }
}
