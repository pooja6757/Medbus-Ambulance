package com.ambulance.proj.myambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Select_aanimal_amb extends AppCompatActivity {

    ImageButton b1,b2,b3,b4;
    String name,cost;
    TextView n1,n2,n3,n4,c1,c2,c3,c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_aanimal_amb);
        final Intent intent=new Intent(this,Select_animal_hospital.class);

        b1=(ImageButton)findViewById(R.id.animalamb1);
        b2=(ImageButton)findViewById(R.id.animalamb2);
        b3=(ImageButton)findViewById(R.id.animalamb3);
        b4=(ImageButton)findViewById(R.id.animalamb4);

        n1=(TextView)findViewById(R.id.name1);
        n2=(TextView)findViewById(R.id.name2);
        n3=(TextView)findViewById(R.id.name3);
        n4=(TextView)findViewById(R.id.name4);

        c1=(TextView)findViewById(R.id.rs1);
        c2=(TextView)findViewById(R.id.rs2);
        c3=(TextView)findViewById(R.id.rs3);
        c4=(TextView)findViewById(R.id.rs4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=n1.getText().toString();
                cost=c1.getText().toString();

                intent.putExtra("EXTRA_NAME",name);
                intent.putExtra("EXTRA_COST",cost);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=n2.getText().toString();
                cost=c2.getText().toString();

                intent.putExtra("EXTRA_NAME",name);
                intent.putExtra("EXTRA_COST",cost);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=n3.getText().toString();
                cost=c3.getText().toString();

                intent.putExtra("EXTRA_NAME",name);
                intent.putExtra("EXTRA_COST",cost);
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=n4.getText().toString();
                cost=c4.getText().toString();

                intent.putExtra("EXTRA_NAME",name);
                intent.putExtra("EXTRA_COST",cost);
                startActivity(intent);
            }
        });
    }
}



