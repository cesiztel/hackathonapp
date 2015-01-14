package com.m2clabthon.hackathonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.m2clabthon.hackathonapp.R;
import com.m2clabthon.hackathonapp.model.Speaker;

import java.util.ArrayList;

/**
 * Created by izquierdo-tello on 14/01/2015.
 */
public class SpeakerAdapter extends ArrayAdapter<Speaker> {


    public SpeakerAdapter(Context context, ArrayList<Speaker> speakers) {
        super(context, 0 , speakers);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // If we weren't given a view, inflate one
        if (convertView == null) {
            final Context context = getContext();
            final LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(android.R.layout.simple_list_item_1,
                                             null);
        }
        // Configure the view for this Crime
        Speaker c = getItem(position);

        TextView titleTextView =
                (TextView)convertView.findViewById(android.R.id.text1);
        titleTextView.setText(c.getName());

        return convertView;
    }

}
