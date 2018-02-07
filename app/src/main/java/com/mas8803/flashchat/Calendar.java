package com.mas8803.flashchat;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.TimeZone;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        try {
            Intent i = new Intent();
            ComponentName cn = null;
            if (Integer.parseInt(Build.VERSION.SDK) >= 8) {
                cn = new ComponentName("com.android.calendar",
                        "com.android.calendar.LaunchActivity");

            } else {
                cn = new ComponentName("com.google.android.calendar",
                        "com.android.calendar.LaunchActivity");
            }
            i.setComponent(cn);
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            // TODO: handle exception
            Log.e("ActivityNotFound", e.toString());
        }



    }
}
