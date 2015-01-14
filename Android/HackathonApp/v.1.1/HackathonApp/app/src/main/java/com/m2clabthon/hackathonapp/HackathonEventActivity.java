package com.m2clabthon.hackathonapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.m2clabthon.hackathonapp.adapter.SpeakerAdapter;
import com.m2clabthon.hackathonapp.global.HackathonManager;
import com.m2clabthon.hackathonapp.model.Speaker;

import java.util.ArrayList;


public class HackathonEventActivity extends ActionBarActivity {

    public final static String EXTRA_SPEAKER_ID = "com.m2clabthon.hackathonapp.SPEAKER_ID";

    private ArrayList<Speaker> mSpeakers;

    private ListView mSpeakersListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon_event);

        // get the list of talks with the singleton pattern
        // we only get what the controller and view needs
        this.mSpeakers         = HackathonManager.get(this).getTalks();

        //get the reference
        this.mSpeakersListView = (ListView) findViewById(R.id.speakers_list);

        //we create an adapter to load the list
        /*
        * ArrayAdapter<Speaker> adapter = new ArrayAdapter<Speaker>(this,
        *                                                           android.R.layout.simple_list_item_1,
        *                                                           this.mSpeakers)
        * */
        final SpeakerAdapter adapter =
                new SpeakerAdapter(this, this.mSpeakers);

        this.mSpeakersListView.setAdapter(adapter);

        //add listener
        this.mSpeakersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // get the speacker
                 Speaker speaker = (Speaker) adapterView.getItemAtPosition(i);

                // call to the talk activity
                /*Intent intent;
                intent = new Intent(getBaseContext(),
                                    HackathonTalkActivity.class);
                startActivity(intent);*/

                // now call the intent with parameters
                // with the intents you can also control the stack
                // of screens
                Intent intent;
                intent = new Intent(getBaseContext(),
                        HackathonTalkActivity.class);
                intent.putExtra(EXTRA_SPEAKER_ID, speaker.getId().toString());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hackathon_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
