package com.example.gov.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toolbar;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;


import com.example.gov.Activity.RegisterActivity;
import com.example.gov.R;
import com.google.firebase.auth.FirebaseAuth;



public class Fragment_Settings_Preference extends PreferenceFragmentCompat {
    Toolbar toolbar;
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(com.example.gov.R.xml.shared_preferences);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(getContext());
        findPreference("switch_preference_1").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                Intent intent=new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }
}
