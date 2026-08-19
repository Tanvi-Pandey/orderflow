package com.stockexchange.service;

import com.stockexchange.model.Order;
import com.stockexchange.orderbook.OrderBook;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class OrderBookStatisticsService {

    private final OrderBook orderBook;

    public OrderBookStatisticsService(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public int getTotalBuyQuantity() {
        return calculateTotalQuantity(
                orderBook.getBuyOrderBook()
                        .getBuyOrders()
                        .values()
        );
    }

    public int getTotalSellQuantity() {
        return calculateTotalQuantity(
                orderBook.getSellOrderBook()
                        .getSellOrders()
                        .values()
        );
    }

    public int getTotalOrders() {
        return getBuyOrderCount() + getSellOrderCount();
    }

    public int getBuyOrderCount() {
        return countOrders(
                orderBook.getBuyOrderBook()
                        .getBuyOrders()
                        .values()
        );
    }

    public int getSellOrderCount() {
        return countOrders(
                orderBook.getSellOrderBook()
                        .getSellOrders()
                        .values()
        );
    }

    private int calculateTotalQuantity(
            Iterable<Queue<Order>> levels) {

        int total = 0;

        for (Queue<Order> orders : levels) {
            for (Order order : orders) {
                total += order.getQuantity();
            }
        }

        return total;
    }

    private int countOrders(
            Iterable<Queue<Order>> levels) {

        int count = 0;

        for (Queue<Order> orders : levels) {
            count += orders.size();
        }

        return count;
    }
}