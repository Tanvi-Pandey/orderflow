package com.stockexchange.service;

import com.stockexchange.enums.OrderSide;
import com.stockexchange.enums.OrderStatus;
import com.stockexchange.enums.OrderType;
import com.stockexchange.model.Order;
import com.stockexchange.model.Trade;
import com.stockexchange.orderbook.OrderBook;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class MatchingEngine {

    private final OrderBook orderBook;
    private final TradeService tradeService;
    private final AtomicLong tradeIdGenerator = new AtomicLong(1);

    public MatchingEngine(OrderBook orderBook, TradeService tradeService) {
        this.orderBook = orderBook;
        this.tradeService = tradeService;
    }

    public void processOrder(Order order) {
        if (order.getSide() == OrderSide.BUY) {
            processBuyOrder(order);
        } else {
            processSellOrder(order);
        }
    }

    private void processBuyOrder(Order buyOrder) {
        int initialQuantity = buyOrder.getQuantity();

        while (buyOrder.getQuantity() > 0 && !orderBook.getSellOrderBook().isEmpty()) {
            Order bestSell = orderBook.getSellOrderBook().peekBestOrder();

            if (bestSell == null || !canMatch(buyOrder, bestSell)) {
                break;
            }

            executeTrade(buyOrder, bestSell);

            // Clean up the resting order if fully filled
            if (bestSell.getQuantity() == 0) {
                orderBook.getSellOrderBook().removeBestOrder();
            }
        }

        // Set status for the incoming order after matching phase
        if (buyOrder.getQuantity() == 0) {
            buyOrder.setStatus(OrderStatus.FILLED);
        } else if (buyOrder.getQuantity() < initialQuantity) {
            buyOrder.setStatus(OrderStatus.PARTIALLY_FILLED);
            orderBook.getBuyOrderBook().addOrder(buyOrder);
        } else {
            buyOrder.setStatus(OrderStatus.OPEN);
            orderBook.getBuyOrderBook().addOrder(buyOrder);
        }
    }

    private void processSellOrder(Order sellOrder) {
        int initialQuantity = sellOrder.getQuantity();

        while (sellOrder.getQuantity() > 0 && !orderBook.getBuyOrderBook().isEmpty()) {
            Order bestBuy = orderBook.getBuyOrderBook().peekBestOrder();

            if (bestBuy == null || !canMatch(bestBuy, sellOrder)) {
                break;
            }

            executeTrade(bestBuy, sellOrder);

            // Clean up the resting order if fully filled
            if (bestBuy.getQuantity() == 0) {
                orderBook.getBuyOrderBook().removeBestOrder();
            }
        }

        // Set status for the incoming order after matching phase
        if (sellOrder.getQuantity() == 0) {
            sellOrder.setStatus(OrderStatus.FILLED);
        } else if (sellOrder.getQuantity() < initialQuantity) {
            sellOrder.setStatus(OrderStatus.PARTIALLY_FILLED);
            orderBook.getSellOrderBook().addOrder(sellOrder);
        } else {
            sellOrder.setStatus(OrderStatus.OPEN);
            orderBook.getSellOrderBook().addOrder(sellOrder);
        }
    }

    private boolean canMatch(Order buyOrder, Order sellOrder) {
        if (buyOrder.getType() == OrderType.MARKET || sellOrder.getType() == OrderType.MARKET) {
            return true;
        }
        return buyOrder.getPrice() >= sellOrder.getPrice();
    }

    private void executeTrade(Order buyOrder, Order sellOrder) {
        int tradedQuantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());

        // Price-Time Priority: Trade executes at the RESTING (maker) order's price
        double tradePrice;
        if (buyOrder.getType() == OrderType.MARKET) {
            tradePrice = sellOrder.getPrice(); // Maker is sell order
        } else if (sellOrder.getType() == OrderType.MARKET) {
            tradePrice = buyOrder.getPrice();  // Maker is buy order
        } else {
            tradePrice = sellOrder.getPrice(); // Resting sell order price
        }

        // Deduct quantities
        buyOrder.setQuantity(buyOrder.getQuantity() - tradedQuantity);
        sellOrder.setQuantity(sellOrder.getQuantity() - tradedQuantity);

        // Update resting order status immediately
        updateOrderStatus(sellOrder);
        updateOrderStatus(buyOrder);

        // Record Trade
        Trade trade = new Trade();
        trade.setTradeId(tradeIdGenerator.getAndIncrement());
        trade.setBuyOrderId(buyOrder.getOrderId());
        trade.setSellOrderId(sellOrder.getOrderId());
        trade.setSymbol(buyOrder.getSymbol());
        trade.setPrice(tradePrice);
        trade.setQuantity(tradedQuantity);
        trade.setTimestamp(LocalDateTime.now());

        tradeService.addTrade(trade);

        System.out.println("--------------------------------");
        System.out.println("TRADE EXECUTED");
        System.out.println("BUY ORDER : " + buyOrder.getOrderId());
        System.out.println("SELL ORDER: " + sellOrder.getOrderId());
        System.out.println("SYMBOL    : " + trade.getSymbol());
        System.out.println("PRICE     : " + trade.getPrice());
        System.out.println("QUANTITY  : " + trade.getQuantity());
        System.out.println("--------------------------------");
    }

    private void updateOrderStatus(Order order) {
        if (order.getQuantity() == 0) {
            order.setStatus(OrderStatus.FILLED);
        } else {
            order.setStatus(OrderStatus.PARTIALLY_FILLED);
        }
    }

    public OrderBook getOrderBook() {
        return orderBook;
    }

    public TradeService getTradeService() {
        return tradeService;
    }
}