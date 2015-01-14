package com.m2clabthon.hackathonapp.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m2clabthon.hackathonapp.R;
import com.m2clabthon.hackathonapp.global.HackathonManager;
import com.m2clabthon.hackathonapp.model.Speaker;

import java.util.Random;
import java.util.UUID;


/**
 * Created by izquierdo-tello on 14/01/2015.
 */
public class HackathonTalkFragment  extends Fragment{

    private Speaker speaker;
    private TextView tvSpeaker;
    private UUID mSpeakerId;

    /*
    * Singleton pattern
    * */
    public static HackathonTalkFragment newInstance()
    {

        HackathonTalkFragment fragment;
        fragment = new HackathonTalkFragment();

        return fragment;
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mSpeakerId      =  (UUID) getActivity().getIntent()
                                .getSerializableExtra(HackathonEventFragment.EXTRA_SPEAKER_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstance)
    {
        View v;

        //Inflate the layout for this fragment
        v     = inflater.inflate(R.layout.activity_hackathon_talk, container, false);

        // load the model
        this.speaker = HackathonManager.get(getActivity()).getSpeaker(mSpeakerId);

        // get the quote
        Resources res = getResources();
        String[] quotes = res.getStringArray(R.array.quotes);

        // get the view resources
        this.tvSpeaker = (TextView) v.findViewById(R.id.speaker_speech);

        //modify the view
        this.tvSpeaker.setText(speaker.getName() + " " + res.getString(R.string.says) + " " + quotes[randInt(0, quotes.length - 1)]);

        return v;

    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}
