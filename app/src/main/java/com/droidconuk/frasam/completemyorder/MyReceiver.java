package com.droidconuk.frasam.completemyorder;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.droidconuk.frasam.completemyorder.model.CartItem;
import com.droidconuk.frasam.completemyorder.service.FireBasDataService;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Samuele on 10/29/16.
 */

public class MyReceiver extends BroadcastReceiver {

    public static final String ACTION_NAME = "com.droidconuk.frasam.completemyorder.MyReceiver.ACTION_NAME";
    public static final String INTENT_DATAWEDGE_SOURCE = "com.motorolasolutions.emdk.datawedge.source";
    public static final String INTENT_DATAWEDGE_DATA = "com.motorolasolutions.emdk.datawedge.data_string";


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(action.equals(ACTION_NAME)) {
            String source = intent.getStringExtra(INTENT_DATAWEDGE_SOURCE);

            if("scanner".equalsIgnoreCase(source)) {
                String data = intent.getStringExtra(INTENT_DATAWEDGE_DATA);

                if(data != null && data.length() > 0) {

                    if(data.startsWith(FireBasDataService.CART_CODE_KEY)) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(FireBasDataService.CART_CODE_KEY, data);
                        editor.commit();
                    } else {
                        Intent addToCartIntent = new Intent(context, FireBasDataService.class);
                        addToCartIntent.putExtra(FireBasDataService.INTENT_PRODUCT_CODE, data);

                        context.startService(addToCartIntent);
                    }


                    Log.i("INTENT_RECEIVER", "DATA RECEIVED " + data);
                }
            }
        }
    }
}

