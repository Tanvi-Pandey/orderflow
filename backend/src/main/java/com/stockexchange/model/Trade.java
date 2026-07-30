package com.stockexchange.model;

import java.time.LocalDateTime;

public class Trade {

    private long tradeId;
    private long buyOrderId;
    private long sellOrderId;
    private String symbol;
    private double price;
    private int quantity;
    private LocalDateTime timestamp;

    public Trade() {
    }

    public Trade(long tradeId,
                 long buyOrderId,
                 long sellOrderId,
                 String symbol,
                 double price,
                 int quantity,
                 LocalDateTime timestamp) {

        this.tradeId = tradeId;
        this.buyOrderId = buyOrderId;
        this.sellOrderId = sellOrderId;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public long getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public long getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(long sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}