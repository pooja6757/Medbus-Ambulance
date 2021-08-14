package com.ambulance.proj.myambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Select_animal_and_human extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_animal_and_human);
    }
    public  void humanclick(View v)
    {
        Intent i=new Intent(Select_animal_and_human.this,Cost_Activity.class);
        startActivity(i);
    }
    public void animalclick(View v)
    {
        Intent i=new Intent(Select_animal_and_human.this,Select_aanimal_amb.class);
        startActivity(i);
    }
}
