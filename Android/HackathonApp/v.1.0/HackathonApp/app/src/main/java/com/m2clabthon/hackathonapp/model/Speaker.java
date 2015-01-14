package com.m2clabthon.hackathonapp.model;

import java.util.UUID;

/**
 * Created by izquierdo-tello on 14/01/2015.
 */
public class Speaker {

    private UUID mId;
    private String mName;

    public Speaker(String mName)
    {
        this.mId   = UUID.randomUUID();
        this.mName = mName;
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public UUID getId() {
        return mId;
    }

    // we don´t want modification in the Id from
    // other classes
    /*public void setId(UUID mId) {
        this.mId = mId;
    }*/

}// end of Speacker class.
