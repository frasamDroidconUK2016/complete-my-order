package com.droidconuk.frasam.completemyorder.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("collectedItems", collectedItems);
        result.put("items", items);

        return result;
    }
}
