package com.example.broadcastlifeformdetected;

import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // on button click, we will broadcast
    public void onButtonClick(View view) {

        // creating an intent - with intent - [action, data, category] - using action name :
        Intent intent = new Intent(LifeFormDetectedReceiver.NEW_LIFEFORM);

        // name value pairs
        intent.putExtra(LifeFormDetectedReceiver.EXTRA_LIFEFORM_NAME, "professor");
        intent.putExtra(LifeFormDetectedReceiver.EXTRA_LATITUDE, 47.6);
        intent.putExtra(LifeFormDetectedReceiver.EXTRA_LONGITUDE, -122.3);

        // broadcast the intent
        sendBroadcast(intent);

        Log.i("myLog", "Broadcasting new life form detected");
    }


    // The following to be part of Application with Broadcast Receiver

    // Registering broadcast receiver in code, especially if Receiver has to update UI
    private IntentFilter filter = new IntentFilter(LifeFormDetectedReceiver.NEW_LIFEFORM);
    private LifeFormDetectedReceiver receiver = new LifeFormDetectedReceiver();

    @Override
    protected void onResume() {
        super.onResume();

        // register the receiver
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        // unregister the receiver
        unregisterReceiver(receiver);

        super.onPause();
    }



}
