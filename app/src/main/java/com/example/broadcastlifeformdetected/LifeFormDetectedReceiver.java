package com.example.broadcastlifeformdetected;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.TextView;


public class LifeFormDetectedReceiver extends BroadcastReceiver {

    public static final String NEW_LIFEFORM = "com.example.broadcastlifeformdetected.action.NEW_LIFEFORM";
    public final static String EXTRA_LIFEFORM_NAME = "EXTRA_LIFEFORM_NAME";
    public final static String EXTRA_LATITUDE = "EXTRA_LATITUDE";
    public final static String EXTRA_LONGITUDE = "EXTRA_LONGITUDE";

    public static final String ACTION_BURN = "com.example.broadcastlifeformdetected.action.BURN_IT_WITH_FIRE";

    // Executed on main application thread, when broadcast intent is received
    // that matches the Intent Filter used to register
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("myLog", "LifeFormDetectedReceiver onReceive() being executed");

        // Get the lifeform details from the intent.
        Uri data = intent.getData();

        // get back the name value pairs
        String name = intent.getStringExtra(EXTRA_LIFEFORM_NAME);
        double lat = intent.getDoubleExtra(EXTRA_LATITUDE, 0);
        double lng = intent.getDoubleExtra(EXTRA_LONGITUDE, 0);

        Log.i("myLog", name + " " + lat + " " + lng);

        /*
        Location loc = new Location("gps");
        loc.setLatitude(lat);
        loc.setLongitude(lng);
        */

        /*
        if (name.equals("facehugger")) {
            // creating an intent with same data received
            Intent startIntent = new Intent(ACTION_BURN, data);
            startIntent.putExtra(EXTRA_LATITUDE, lat);
            startIntent.putExtra(EXTRA_LONGITUDE, lng);

            // start service
            context.startService(startIntent);
        }
        */
        }
    }

