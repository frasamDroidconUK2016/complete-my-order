package com.droidconuk.frasam.completemyorder.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Samuele on 10/29/16.
 */

@IgnoreExtraProperties
public class Cart {

    private String code;
    private CartItem items;

    public Cart() {

    }

    public Cart(String code, CartItem items) {
        this.code = code;
        this.items = items;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CartItem getItems() {
        return items;
    }

    public void setItems(CartItem items) {
        this.items = items;
    }
}
