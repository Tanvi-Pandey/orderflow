package com.stockexchange.dto;

import com.stockexchange.enums.OrderSide;
import com.stockexchange.enums.OrderType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class OrderRequest {

    @NotBlank(message = "Symbol cannot be empty")
    private String symbol;

    @NotNull(message = "Order side is required")
    private OrderSide side;

    @NotNull(message = "Order type is required")
    private OrderType type;

    @PositiveOrZero(message = "Price cannot be negative")
    private double price;

    @Positive(message = "Quantity must be greater than zero")
    private int quantity;

    public OrderRequest() {
    }

    public OrderRequest(String symbol,
                        OrderSide side,
                        OrderType type,
                        double price,
                        int quantity) {
        this.symbol = symbol;
        this.side = side;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
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