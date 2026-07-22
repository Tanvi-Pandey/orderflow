package com.stockexchange.orderbook;

import com.stockexchange.model.Order;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class SellOrderBook {

    // Lowest price should come first
    private final TreeMap<Double, Queue<Order>> sellOrders =
            new TreeMap<>();

    public void addOrder(Order order) {
        sellOrders
                .computeIfAbsent(order.getPrice(), price -> new LinkedList<>())
                .offer(order);
    }

    public TreeMap<Double, Queue<Order>> getSellOrders() {
        return sellOrders;
    }
}