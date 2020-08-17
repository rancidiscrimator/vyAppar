package com.example.gov.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gov.Adapter.viewPageAdapter2;
import com.example.gov.Adapter.viewpagerAdapter;
import com.example.gov.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.StorageReference;
import com.robertlevonyan.components.picker.PickerDialog;

import de.hdodenhof.circleimageview.CircleImageView;

public class VendorProfileCustomerSide extends AppCompatActivity {



    com.example.gov.ModalClasses.user user;
    RelativeLayout linear, ll;
    CardView cv;
    TextView name, description, category, name2, description2;
    Button button;
    ViewPager viewPager;
    FirebaseAuth auth;
    FirebaseUser user1;
    TabLayout tabLayout;
    PickerDialog pickerDialog;
    CircleImageView saveImage;
    String userId;
    String uri1;
    BottomNavigationView bottomNavigationView;
    Intent intent;
    Spinner spinner;
    private StorageReference storageReference;
    String[] services = {"EDUCATION",
            "FOOD",
            "ART AND DECOR",
            "FREELANCE",
            "GROCERIES",
            "FASHION",
            "RENTAL",
            "HOUSE SERVICES"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_profile_customer_side);
        intent=getIntent();
        userId=intent.getStringExtra("userId");
        Log.e("vendorProfileCustomerSide",userId);



        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new viewPageAdapter2(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}