package com.ambulance.proj.myambulance;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class SumoOxygen extends AppCompatActivity {

    private ImageView profilePic;
    private TextView profileName, profilePhone, profileEmail,profileAmb;
    private Button profileUpdate, profilecancel;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseStorage firebaseStorage;
    private StorageReference pathReference;
    String add,rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumo_oxygen);

        profilePic = findViewById(R.id.sumoOxyPic);
        profileName = findViewById(R.id.sumoOxyDiverName);
        profilePhone = findViewById(R.id.sumoOxyDriverPhone);
        profileEmail = findViewById(R.id.sumoOxyDriverEmail);
        profileAmb = findViewById(R.id.sumoOxyDriverAmbNo);
        profileUpdate = findViewById(R.id.sumoOxyconf);
        profilecancel=findViewById(R.id.sumoOxycancel);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("UserProfile");

        // StorageReference storageReference = firebaseStorage.getReference();

       /*storageReference.child("UserProfile").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).fit().centerCrop().into(profilePic);
            }
        });*/
        StorageReference storageReference = firebaseStorage.getReference();
        storageReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("UserProfile/Images/Profile Pic").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                Picasso.get().load(uri).fit().centerCrop().into(profilePic);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SumoOxygen.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        /*StorageReference mImageRef =
                FirebaseStorage.getInstance().getReference("UserProfile");
        final long ONE_MEGABYTE = 1024 * 1024;
        mImageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        DisplayMetrics dm = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(dm);

                        profilePic.setMinimumHeight(dm.heightPixels);
                        profilePic.setMinimumWidth(dm.widthPixels);
                        profilePic.setImageBitmap(bm);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });*/

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getValue(UserProfile.class);

                profileName.setText("Diver Name: "+userProfile.getUserName());
                profilePhone.setText("Phone: "+userProfile.getUserPhone().toString());
                profileEmail.setText("Email: "+userProfile.getUserEmail());
                profileAmb.setText("Vehicle No: "+userProfile.getUserAmbNo());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SumoOxygen.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        profileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dname=profileName.getText().toString();
                String dphone=profilePhone.getText().toString();
                String dAmbNo=profileAmb.getText().toString();
                //startActivity(new Intent(ProfileActivity.this, UpdateProfile.class));
                Random r=new Random();
                int randomNumber=r.nextInt(1000)+9999;
                String verifyNo=String.valueOf(randomNumber);
                String phoneNo1 =LoginOtp.mobile;
                String phoneNo2=profilePhone.getText().toString();
                String hospitalAddr=Select_animal_hospital.address;
                String rs=Select_animal_hospital.costrs;
                String address=hospitalAddr+"\n"+"Verification Code: "+verifyNo+"\n"+"Total Cost: "+rs;
                String sms = dname+"\n"+dphone+"\n"+dAmbNo+"\n"+"Verification code: "+verifyNo;

                try {
                    SmsManager smsManager1 = SmsManager.getDefault();
                    smsManager1.sendTextMessage(phoneNo1, null, sms, null, null);

                    SmsManager smsManager2 = SmsManager.getDefault();
                    smsManager2.sendTextMessage(phoneNo2, null, address, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent!",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }

        });


        profilecancel.setOnClickListener(new View.OnClickListener() {
            String no=OtpActivity.mobile;
            @Override
            public void onClick(View view) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.child("UserPhone").orderByChild("phone").equalTo(no);
                String phoneNo2=profilePhone.getText().toString();
                String msg="From KRPS Transport Services,"+"\n"+"Booking is canceled";
                String phoneNo1=LoginOtp.mobile;
                String sms="From KRPS Transport Services,"+"\n"+"Your booking is canceled!";
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(SumoOxygen.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
                    }
                });
                try {

                    SmsManager smsManager1 = SmsManager.getDefault();
                    smsManager1.sendTextMessage(phoneNo1, null, sms, null, null);

                    SmsManager smsManager2 = SmsManager.getDefault();
                    smsManager2.sendTextMessage(phoneNo2, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "Booking canceled",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            " please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });

    }

}
