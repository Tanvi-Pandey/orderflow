package com.stockexchange.dto;

public class PriceLevelResponse {

    private double price;
    private int quantity;

    public PriceLevelResponse() {
    }

    public PriceLevelResponse(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}