package com.droidconuk.frasam.completemyorder.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuele on 10/29/16.
 */

@IgnoreExtraProperties
public class Cart {

    private String code;
    private List<CartItem> collectedItems = new ArrayList<>();
    private List<CartItem> items = new ArrayList<>();

    public Cart() {

    }

    public Cart(String code, List<CartItem> collectedItems, List<CartItem> items) {
        this.code = code;
        this.collectedItems = collectedItems;
        this.items = items;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CartItem> getCollectedItems() {
        return collectedItems;
    }

    public void setCollectedItems(List<CartItem> collectedItems) {
        this.collectedItems = collectedItems;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
