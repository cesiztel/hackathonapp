package com.m2clabthon.hackathonapp.global;

import android.content.Context;

import com.m2clabthon.hackathonapp.model.Speaker;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by izquierdo-tello on 14/01/2015.
 */
public class HackathonManager {

    private ArrayList<Speaker> mTalks;

    private static HackathonManager sHackathonManager;
    private Context mAppContext;

    private HackathonManager(Context mAppContext)
    {
        this.mAppContext = mAppContext;
        this.mTalks = new ArrayList<Speaker>();

        // generating talks
        this.mTalks.add(new Speaker("Cesar"));
        this.mTalks.add(new Speaker("Sebastian"));
        this.mTalks.add(new Speaker("Michael"));
        this.mTalks.add(new Speaker("Marcel"));
        this.mTalks.add(new Speaker("Rafael"));
    }

    public static HackathonManager get(Context c)
    {
        if(sHackathonManager == null) {
            sHackathonManager = new HackathonManager(c.getApplicationContext());
        }
        return sHackathonManager;
    }

    public ArrayList<Speaker> getTalks(){
        return this.mTalks;
    }

    public Speaker getSpeaker(UUID id) {
        for(Speaker s : this.mTalks) {
            if(s.getId().equals(id)) {
                return s;
            }
        }

        return null;
    }

}// end manager class

