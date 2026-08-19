package com.stockexchange.dto;

import com.stockexchange.enums.OrderStatus;

public class OrderStatusResponse {

    private long orderId;
    private String symbol;
    private OrderStatus status;
    private int remainingQuantity;

    public OrderStatusResponse() {
    }

    public OrderStatusResponse(
            long orderId,
            String symbol,
            OrderStatus status,
            int remainingQuantity) {

        this.orderId = orderId;
        this.symbol = symbol;
        this.status = status;
        this.remainingQuantity = remainingQuantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
}