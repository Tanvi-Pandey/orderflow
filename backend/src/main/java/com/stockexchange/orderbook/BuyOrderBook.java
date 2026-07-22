package com.stockexchange.orderbook;

import com.stockexchange.model.Order;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BuyOrderBook {

    // Highest price should come first
    private final TreeMap<Double, Queue<Order>> buyOrders =
            new TreeMap<>((a, b) -> Double.compare(b, a));

    public void addOrder(Order order) {
        buyOrders
                .computeIfAbsent(order.getPrice(), price -> new LinkedList<>())
                .offer(order);
    }

    public TreeMap<Double, Queue<Order>> getBuyOrders() {
        return buyOrders;
    }
}