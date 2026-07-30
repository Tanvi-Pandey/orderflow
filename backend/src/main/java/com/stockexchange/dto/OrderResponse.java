package com.stockexchange.dto;

import com.stockexchange.enums.OrderStatus;

public class OrderResponse {

    private long orderId;
    private String symbol;
    private OrderStatus status;
    private String message;

    public OrderResponse() {
    }

    public OrderResponse(long orderId,
                         String symbol,
                         OrderStatus status,
                         String message) {
        this.orderId = orderId;
        this.symbol = symbol;
        this.status = status;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}