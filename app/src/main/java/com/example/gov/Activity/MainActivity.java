package com.example.gov.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.gov.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser fbuser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();





        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(auth.getCurrentUser()!=null)
                {
                    fbuser=auth.getCurrentUser();
                    FirebaseFirestore firestore=FirebaseFirestore.getInstance();
                    firestore.collection("Vendor").document(fbuser.getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            Long a= (Long) documentSnapshot.get("type");
                            if(a==0)
                            {
                                Intent intent=new Intent(MainActivity.this,Activity_MAIN.class);
                                startActivity(intent);

                            }else if(a==1){
                                Intent intent=new Intent(MainActivity.this,VendorAuth.class);
                                intent.putExtra("value","1");
                                startActivity(intent);
                            }


                        }
                    });



                }else{
                Intent intent= new Intent(MainActivity.this, LoginScreen.class);
                startActivity(intent);}

            }
        },1000);


    }
}