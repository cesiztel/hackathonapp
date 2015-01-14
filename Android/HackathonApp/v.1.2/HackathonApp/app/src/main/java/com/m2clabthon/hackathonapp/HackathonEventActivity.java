package com.m2clabthon.hackathonapp;


import android.support.v4.app.Fragment;
import com.m2clabthon.hackathonapp.fragments.HackathonEventFragment;



public class HackathonEventActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new HackathonEventFragment();
    }

}
