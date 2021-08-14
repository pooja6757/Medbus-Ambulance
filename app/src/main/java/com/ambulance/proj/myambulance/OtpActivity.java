package com.ambulance.proj.myambulance;


import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OtpActivity extends Activity {

    Button buttonSend,bverify;
    EditText textPhoneNo;
    EditText textSMS;
    String verifyNo;
    DatabaseReference databaseReference;
    public static String mobile;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        buttonSend = (Button) findViewById(R.id.bgenerate);
        textPhoneNo = (EditText) findViewById(R.id.etOtp);

        databaseReference=FirebaseDatabase.getInstance().getReference("UserPhone");
        buttonSend.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String phoneNo = textPhoneNo.getText().toString();
                String id=databaseReference.push().getKey();
                mobile=phoneNo;
                if (phoneNo.isEmpty()) {
                    textPhoneNo.setError("Phone is empty");
                    textPhoneNo.requestFocus();
                    return;
                }

                if (phoneNo.length() != 10) {
                    textPhoneNo.setError("Invalid phone number");
                    textPhoneNo.requestFocus();
                    return;
                }
                PhoneTest pt = new PhoneTest(id,phoneNo);

                FirebaseDatabase.getInstance().getReference("UserPhone")
                        .child(id).setValue(pt);
                Toast.makeText(OtpActivity.this,"Registration successfull",Toast.LENGTH_SHORT);
                Intent i=new Intent(OtpActivity.this,LoginOtp.class);
                startActivity(i);


            }
        });

    }
}
