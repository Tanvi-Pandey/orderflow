package com.stockexchange.orderbook;

import com.stockexchange.model.Order;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BuyOrderBook {

    // Highest price first
    private final TreeMap<Double, Queue<Order>> buyOrders =
            new TreeMap<>((a, b) -> Double.compare(b, a));

    public void addOrder(Order order) {
        buyOrders
                .computeIfAbsent(order.getPrice(), p -> new LinkedList<>())
                .offer(order);
    }

    public Order peekBestOrder() {
        if (buyOrders.isEmpty()) {
            return null;
        }

        return buyOrders.firstEntry().getValue().peek();
    }

    public Order removeBestOrder() {

        if (buyOrders.isEmpty()) {
            return null;
        }

        Queue<Order> queue = buyOrders.firstEntry().getValue();

        Order order = queue.poll();

        if (queue.isEmpty()) {
            buyOrders.pollFirstEntry();
        }

        return order;
    }

    public void updateBestOrder(Order order) {

        if (buyOrders.isEmpty()) {
            return;
        }

        Queue<Order> queue = buyOrders.firstEntry().getValue();

        queue.poll();

        queue.offer(order);
    }

    public Double getBestPrice() {

        if (buyOrders.isEmpty()) {
            return null;
        }

        return buyOrders.firstKey();
    }

    public boolean isEmpty() {
        return buyOrders.isEmpty();
    }

    public TreeMap<Double, Queue<Order>> getBuyOrders() {
        return buyOrders;
    }

    public void clear() {
        buyOrders.clear();
    }
}