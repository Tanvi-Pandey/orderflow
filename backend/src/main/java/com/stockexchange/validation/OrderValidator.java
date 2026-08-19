package com.stockexchange.validation;

import com.stockexchange.enums.OrderSide;
import com.stockexchange.enums.OrderType;
import com.stockexchange.model.Order;
import com.stockexchange.exception.InvalidOrderException;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    public void validate(Order order) {

        if (order == null) {
            throw new InvalidOrderException("Order cannot be null");
        }

        if (order.getOrderId() <= 0) {
            throw new InvalidOrderException(
                    "Order ID must be greater than 0"
            );
        }

        if (order.getSymbol() == null ||
                order.getSymbol().isBlank()) {

            throw new InvalidOrderException(
                    "Symbol cannot be empty"
            );
        }

        if (order.getSide() == null) {
            throw new InvalidOrderException(
                    "Order side is required"
            );
        }

        if (order.getType() == null) {
            throw new InvalidOrderException(
                    "Order type is required"
            );
        }

        if (order.getQuantity() <= 0) {
            throw new InvalidOrderException(
                    "Quantity must be greater than 0"
            );
        }

        if (order.getType() == OrderType.LIMIT &&
                order.getPrice() <= 0) {

            throw new InvalidOrderException(
                    "Limit order price must be greater than 0"
            );
        }

        if (order.getSide() != OrderSide.BUY &&
                order.getSide() != OrderSide.SELL) {

            throw new InvalidOrderException(
                    "Invalid order side"
            );
        }
    }
}