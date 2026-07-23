package com.stockexchange.orderbook;

import com.stockexchange.model.Order;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class SellOrderBook {

    // Lowest price first
    private final TreeMap<Double, Queue<Order>> sellOrders =
            new TreeMap<>();

    public void addOrder(Order order) {

        sellOrders
                .computeIfAbsent(order.getPrice(), p -> new LinkedList<>())
                .offer(order);
    }

    public Order peekBestOrder() {

        if (sellOrders.isEmpty()) {
            return null;
        }

        return sellOrders.firstEntry().getValue().peek();
    }

    public Order removeBestOrder() {

        if (sellOrders.isEmpty()) {
            return null;
        }

        Queue<Order> queue = sellOrders.firstEntry().getValue();

        Order order = queue.poll();

        if (queue.isEmpty()) {
            sellOrders.pollFirstEntry();
        }

        return order;
    }

    public void updateBestOrder(Order order) {

        if (sellOrders.isEmpty()) {
            return;
        }

        Queue<Order> queue = sellOrders.firstEntry().getValue();

        queue.poll();

        queue.offer(order);
    }

    public Double getBestPrice() {

        if (sellOrders.isEmpty()) {
            return null;
        }

        return sellOrders.firstKey();
    }

    public boolean isEmpty() {
        return sellOrders.isEmpty();
    }

    public TreeMap<Double, Queue<Order>> getSellOrders() {
        return sellOrders;
    }

    public void clear() {
        sellOrders.clear();
    }
}