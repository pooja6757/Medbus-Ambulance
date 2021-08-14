package com.ambulance.proj.myambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Select_Driver_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__driver__user);
    }
    public void clickDriver(View v)
    {
        Intent i=new Intent(Select_Driver_User.this, Login_reg_driver.class);
        startActivity(i);
    }
    public void clickUser(View v)
    {
        Intent i=new Intent(Select_Driver_User.this, Login_reg_user.class);
        startActivity(i);
    }
}
