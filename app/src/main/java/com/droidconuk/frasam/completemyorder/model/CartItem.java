package com.droidconuk.frasam.completemyorder.model;

/**
 * Created by Samuele on 10/29/16.
 */

public class CartItem {

    private String productCode;
    private Integer quantity;

    public CartItem() {
    }

    public CartItem(String productCode, Integer quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
