package com.m2clabthon.hackathonapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.m2clabthon.hackathonapp.HackathonTalkActivity;
import com.m2clabthon.hackathonapp.adapter.SpeakerAdapter;
import com.m2clabthon.hackathonapp.global.HackathonManager;
import com.m2clabthon.hackathonapp.model.Speaker;

import java.util.ArrayList;

/**
 * Created by izquierdo-tello on 14/01/2015.
 */
public class HackathonEventFragment extends ListFragment {

    public final static String EXTRA_SPEAKER_ID = "com.m2clabthon.hackathonapp.SPEAKER_ID";

    private ArrayList<Speaker> mSpeakers;

    /*
    * Singleton pattern
    * */
    public static HackathonEventFragment newInstance()
    {
        HackathonEventFragment fragment;
        fragment = new HackathonEventFragment();

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

        this.mSpeakers         = HackathonManager.get(getActivity()).getTalks();

        final SpeakerAdapter adapter =
                new SpeakerAdapter(getActivity(), this.mSpeakers);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l,
                                View v,
                                int position,
                                long id)
    {

        Speaker speaker = (Speaker) getListAdapter().getItem(position);

        Intent intent;
        intent = new Intent(getActivity(),
                HackathonTalkActivity.class);
        intent.putExtra(EXTRA_SPEAKER_ID, speaker.getId());
        startActivity(intent);
    }

}
