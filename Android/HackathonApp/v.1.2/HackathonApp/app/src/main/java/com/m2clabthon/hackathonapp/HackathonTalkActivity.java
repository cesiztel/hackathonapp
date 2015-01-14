package com.m2clabthon.hackathonapp;

import android.support.v4.app.Fragment;
import com.m2clabthon.hackathonapp.fragments.HackathonTalkFragment;



public class HackathonTalkActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new HackathonTalkFragment();
    }


}// end MainActivity
