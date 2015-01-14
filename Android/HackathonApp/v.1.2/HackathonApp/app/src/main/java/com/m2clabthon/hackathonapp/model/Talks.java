package com.m2clabthon.hackathonapp.model;

import java.util.ArrayList;

/**
 * Created by izquierdo-tello on 14/01/2015.
 */
public class Talks {

    private ArrayList<Speaker> mSpeakerList;

    public Talks(ArrayList<Speaker> mSpeakerList) {
        this.mSpeakerList = mSpeakerList;
    }

    public ArrayList<Speaker> getSpeakerList() {
        return mSpeakerList;
    }

    public void setSpeakerList(ArrayList<Speaker> mSpeakerList) {
        this.mSpeakerList = mSpeakerList;
    }

}
