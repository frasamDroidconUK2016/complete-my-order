package com.droidconuk.frasam.completemyorder.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.droidconuk.frasam.completemyorder.model.Cart;
import com.droidconuk.frasam.completemyorder.model.CartItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Samuele on 10/29/16.
 */

public class FireBasDataService extends IntentService {

    public static final String INTENT_PRODUCT_CODE = "ProductCode";
    public static final String CART_CODE_KEY = "cart_";
    public static final String DEFAULT_CART_CODE = "cart_003";

    public FireBasDataService() {
        super("");
    }

    public FireBasDataService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        final String productCode = intent.getStringExtra(INTENT_PRODUCT_CODE);

        DatabaseReference fireBaseDatabase = FirebaseDatabase.getInstance().getReference();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String cartCode = preferences.getString(CART_CODE_KEY, null);

        if(cartCode == null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(FireBasDataService.CART_CODE_KEY, DEFAULT_CART_CODE);
            editor.commit();
        }

        List<CartItem> items = new ArrayList<CartItem>(){{
            add(new CartItem(productCode, 1));
        }};


        Cart cart = new Cart(DEFAULT_CART_CODE, new ArrayList<CartItem>(), items);
        fireBaseDatabase.child("cart").setValue(cart);


    }
}
