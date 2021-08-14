package com.ambulance.proj.myambulance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Select_animal_hospital extends AppCompatActivity {

    String names[] = {"Dr Hatekars Dogs and Cat Clinic","Dr Gorhe Pet Cover Advanced Veterinary Clinic","Blue Cross Hospital","PetCetera Small Animal Clinic","Government Veterinary Hospital/सरकारी गुरांचा दवाखाना"};
    String km[] = {"3","5","2.5","6","3"};
    String ad[] = {"Karnik Apartments , behind umesh hardware Mehendle Garage Road, Erandwane, Pune, Maharashtra 411004","Dr Gorhe Near Sutar Bus Stand and Karve Statue, Opp Titn Showroom, Kothrud,, Pune, Maharashtra 411038"," 341, Sr. No. 5, Sharad Nagar, Mundhwa, Pune, Maharashtra 411036","32 BIZZBAY, NIBM Undri Rd, Opp State Bank of India, Kondhwa, Pune, Maharashtra 411048","Pune, 411007, Pune University, Ganeshkhind, Pune, Maharashtra 411007"};
    private TextView name,kms,addr,ambtypes,costs;
    private Spinner spinner;
    ImageView ambu,hospital;
    Button requestBook;
    String amname;
    static String  address,costrs;
    Geocoder geocoder = new Geocoder(this, Locale.getDefault());
    List<Address> addresses = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_animal_hospital);

        Intent intent=getIntent();
        name = (TextView) findViewById(R.id.tn);
        kms = (TextView) findViewById(R.id.tk);
        addr = (TextView) findViewById(R.id.ta);
        costs=(TextView)findViewById(R.id.cost);
        ambtypes=(TextView)findViewById(R.id.ambtype);
        requestBook=(Button) findViewById(R.id.request);
        hospital=(ImageView)findViewById(R.id.hospiv);
        ambu=(ImageView)findViewById(R.id.ambiv);

        Button getcost=(Button)findViewById(R.id.button2);
        Button b1 = (Button) findViewById(R.id.button);
        final EditText t1 = (EditText) findViewById(R.id.editText);

        spinner =(Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);

        amname=intent.getStringExtra("EXTRA_NAME");
        final String amcost=intent.getStringExtra("EXTRA_COST");

        setImage(amname);

        getcost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalcost,kilom,costperkm;
                String co;
                String k=kms.getText().toString();
                kilom=Double.valueOf(k);
                costperkm=Double.valueOf(amcost);

                totalcost=kilom*costperkm;
                co= "Rs "+String.valueOf(totalcost);
                costs.setText(co);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    addresses = geocoder.getFromLocation(18.537733, 73.832935, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Log.d("max", " " + addresses.get(0).getMaxAddressLineIndex());

                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                addresses.get(0).getAdminArea();
                t1.setText(address);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setTexts(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        requestBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amname.equals("Small"))
                {   costrs= costs.getText().toString();
                    address=addr.getText().toString();
                    FirebaseAuth firebaseAuth;
                    firebaseAuth = FirebaseAuth.getInstance();
                    String userName="poojarupanwar55@gmail.com";
                    String userPassword="rupanwar55";
                    firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                // Toast.makeText(SelectAmb.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                //basicLogin();
                                Intent i =new Intent(Select_animal_hospital.this,SumoOxygen.class);

                                startActivity(i);
                                //checkEmailVerification();
                            }else{
                                Toast.makeText(Select_animal_hospital.this, "error occured", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

                if(amname.equals("Medium"))
                {
                    costrs= costs.getText().toString();
                    address=addr.getText().toString();
                    FirebaseAuth firebaseAuth;
                    firebaseAuth = FirebaseAuth.getInstance();
                    String userName="kirtisalunkhe15@gmail.com";
                    String userPassword="kirti55555";
                    firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                // Toast.makeText(SelectAmb.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                //basicLogin();
                                Intent i =new Intent(Select_animal_hospital.this,SumoOxygen.class);

                                startActivity(i);
                                //checkEmailVerification();
                            }else{
                                Toast.makeText(Select_animal_hospital.this, "error occured", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

                if(amname.equals("Large"))
                {
                    costrs= costs.getText().toString();
                    address=addr.getText().toString();
                    FirebaseAuth firebaseAuth;
                    firebaseAuth = FirebaseAuth.getInstance();
                    String userName="reeya25@gmail.com";
                    String userPassword="reeya11111";
                    firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                // Toast.makeText(SelectAmb.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                //basicLogin();
                                Intent i =new Intent(Select_animal_hospital.this,SumoOxygen.class);

                                startActivity(i);
                                //checkEmailVerification();
                            }else{
                                Toast.makeText(Select_animal_hospital.this, "error occured", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

                if(amname.equals("Xtra-Large"))
                {
                    costrs= costs.getText().toString();
                    address=addr.getText().toString();
                    FirebaseAuth firebaseAuth;
                    firebaseAuth = FirebaseAuth.getInstance();
                    String userName="sonalkale13@gmail.com";
                    String userPassword="sonal55555";
                    firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                // Toast.makeText(SelectAmb.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                //basicLogin();
                                Intent i =new Intent(Select_animal_hospital.this,SumoOxygen.class);

                                startActivity(i);
                                //checkEmailVerification();
                            }else{
                                Toast.makeText(Select_animal_hospital.this, "error occured", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });

    }

    private void setTexts(int position){
        costs.setText(" ");
        name.setText(names[position]);
        kms.setText(km[position]);
        addr.setText(ad[position]);
    }

    private void setImage(String types)
    {
        ambtypes.setText(types);

        switch (types)
        {
            case "Small":
                ambu.setImageResource(R.drawable.amb4);
                break;
            case "Medium":
                ambu.setImageResource(R.drawable.amb1);
                break;
            case "Large":
                ambu.setImageResource(R.drawable.amb3);
                break;
            case "Xtra-Large":
                ambu.setImageResource(R.drawable.amb5);
                break;
        }
    }

}

