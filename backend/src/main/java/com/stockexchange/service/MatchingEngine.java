package com.stockexchange.service;

import com.stockexchange.enums.OrderSide;
import com.stockexchange.model.Order;
import com.stockexchange.orderbook.OrderBook;

public class MatchingEngine {

    private final OrderBook orderBook;

    public MatchingEngine(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public void processOrder(Order order) {

        if (order.getSide() == OrderSide.BUY) {
            processBuyOrder(order);
        } else {
            processSellOrder(order);
        }
    }

    private void processBuyOrder(Order order) {

    }

    private void processSellOrder(Order order) {

    }

    private void executeTrade(Order buyOrder, Order sellOrder) {

    }

    private void removeFilledOrder(Order order) {

    }

    private void updateOrderStatus(Order order) {

    }

    private boolean canMatch(Order buy, Order sell) {
        return false;
    }
}