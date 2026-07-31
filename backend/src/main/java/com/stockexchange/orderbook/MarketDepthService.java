package com.stockexchange.orderbook;

import com.stockexchange.model.Order;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.springframework.stereotype.Service;

@Service
public class MarketDepthService {

    private final OrderBook orderBook;

    public MarketDepthService(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public MarketDepth getMarketDepth() {

        MarketDepth marketDepth = new MarketDepth();

        // Buy Side
        for (Map.Entry<Double, Queue<Order>> entry :
                orderBook.getBuyOrderBook().getBuyOrders().entrySet()) {

            int totalQuantity = 0;

            for (Order order : entry.getValue()) {
                totalQuantity += order.getQuantity();
            }

            marketDepth.getBids().add(
                    new PriceLevel(entry.getKey(), totalQuantity)
            );
        }

        // Sell Side
        for (Map.Entry<Double, Queue<Order>> entry :
                orderBook.getSellOrderBook().getSellOrders().entrySet()) {

            int totalQuantity = 0;

            for (Order order : entry.getValue()) {
                totalQuantity += order.getQuantity();
            }

            marketDepth.getAsks().add(
                    new PriceLevel(entry.getKey(), totalQuantity)
            );
        }

        return marketDepth;
    }
}