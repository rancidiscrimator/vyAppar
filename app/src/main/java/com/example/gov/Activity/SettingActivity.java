package com.example.gov.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.gov.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        navigationView=findViewById(R.id.bottomNavigation);

        navigationView.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.homebottom):
                Intent intent=new Intent(getApplicationContext(), VendorAuth.class);
                intent.putExtra("value","1");

                startActivity(intent);

                break;

            case (R.id.searchbottom):
                Intent intent2=new Intent(getApplicationContext(), SearchActivity.class);

                startActivity(intent2);
                break;
            case (R.id.cartbottom):
                Intent intent1=new Intent(getApplicationContext(), CartActivity.class);

                startActivity(intent1);
                break;



        }

        return true;
    }
}