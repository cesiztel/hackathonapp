package com.m2clabthon.hackathonapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.m2clabthon.hackathonapp.global.HackathonManager;
import com.m2clabthon.hackathonapp.model.Speaker;

import java.util.Random;
import java.util.UUID;


public class HackathonTalkActivity extends ActionBarActivity {

    private static final String TAG = "com.m2clabthon.hackathonapp.MainActivity";

    private Speaker speaker;
    private TextView tvSpeaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // the view is inflated
        setContentView(R.layout.activity_hackathon_talk);

        //get the information of the intent
        Intent intent = getIntent();
        UUID speakerId = UUID.fromString(intent.getStringExtra(HackathonEventActivity.EXTRA_SPEAKER_ID));

        // load the model
        //this.speaker = new Speaker("César");
        this.speaker = HackathonManager.get(this).getSpeaker(speakerId);

        // get the quote
        Resources res = getResources();
        String[] quotes = res.getStringArray(R.array.quotes);

        // get the view resources
        this.tvSpeaker = (TextView) findViewById(R.id.speaker_speech);

        //modify the view
        this.tvSpeaker.setText(speaker.getName() + " " + res.getString(R.string.says) + " " + quotes[randInt(0, quotes.length - 1)]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}// end MainActivity
