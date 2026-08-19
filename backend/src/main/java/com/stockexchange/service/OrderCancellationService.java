package com.stockexchange.service;

import com.stockexchange.model.Order;
import com.stockexchange.orderbook.OrderBook;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Queue;

@Service
public class OrderCancellationService {

    private final OrderBook orderBook;

    public OrderCancellationService(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public boolean cancelOrder(long orderId) {

        // Search buy orders
        for (Map.Entry<Double, Queue<Order>> entry :
                orderBook.getBuyOrderBook().getBuyOrders().entrySet()) {

            Queue<Order> orders = entry.getValue();

            Order target = findOrder(orders, orderId);

            if (target != null) {
                orders.remove(target);

                if (orders.isEmpty()) {
                    orderBook.getBuyOrderBook()
                            .getBuyOrders()
                            .remove(entry.getKey());
                }

                return true;
            }
        }

        // Search sell orders
        for (Map.Entry<Double, Queue<Order>> entry :
                orderBook.getSellOrderBook().getSellOrders().entrySet()) {

            Queue<Order> orders = entry.getValue();

            Order target = findOrder(orders, orderId);

            if (target != null) {
                orders.remove(target);

                if (orders.isEmpty()) {
                    orderBook.getSellOrderBook()
                            .getSellOrders()
                            .remove(entry.getKey());
                }

                return true;
            }
        }

        return false;
    }

    private Order findOrder(
            Queue<Order> orders,
            long orderId) {

        for (Order order : orders) {

            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        return null;
    }
}