package com.stockexchange.service;

import com.stockexchange.enums.OrderSide;
import com.stockexchange.enums.OrderStatus;
import com.stockexchange.enums.OrderType;
import com.stockexchange.model.Order;
import com.stockexchange.orderbook.OrderBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MatchingEngineTest {

    private MatchingEngine matchingEngine;
    private OrderBook orderBook;
    private TradeService tradeService;

    @BeforeEach
    void setup() {

        orderBook = new OrderBook();
        tradeService = new TradeService();

        matchingEngine =
                new MatchingEngine(orderBook, tradeService);
    }

    @Test
    void shouldAddBuyOrderToBook() {

        Order order = new Order(
                1,
                "AAPL",
                OrderSide.BUY,
                OrderType.LIMIT,
                150,
                100,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        matchingEngine.processOrder(order);

        assertFalse(orderBook.getBuyOrderBook().isEmpty());
    }

    @Test
    void shouldAddSellOrderToBook() {

        Order order = new Order(
                2,
                "AAPL",
                OrderSide.SELL,
                OrderType.LIMIT,
                155,
                100,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        matchingEngine.processOrder(order);

        assertFalse(orderBook.getSellOrderBook().isEmpty());
    }

    @Test
    void shouldExecuteTrade() {

        Order buy = new Order(
                1,
                "AAPL",
                OrderSide.BUY,
                OrderType.LIMIT,
                160,
                100,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        Order sell = new Order(
                2,
                "AAPL",
                OrderSide.SELL,
                OrderType.LIMIT,
                150,
                100,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        matchingEngine.processOrder(buy);
        matchingEngine.processOrder(sell);

        assertEquals(
                1,
                tradeService.getTrades().size()
        );
    }

    @Test
    void shouldPartiallyFillOrder() {

        Order buy = new Order(
                1,
                "AAPL",
                OrderSide.BUY,
                OrderType.LIMIT,
                160,
                100,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        Order sell = new Order(
                2,
                "AAPL",
                OrderSide.SELL,
                OrderType.LIMIT,
                160,
                40,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        matchingEngine.processOrder(buy);
        matchingEngine.processOrder(sell);

        assertEquals(60, buy.getQuantity());
    }

    @Test
    void shouldNotMatchOrders() {

        Order buy = new Order(
                1,
                "AAPL",
                OrderSide.BUY,
                OrderType.LIMIT,
                150,
                100,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        Order sell = new Order(
                2,
                "AAPL",
                OrderSide.SELL,
                OrderType.LIMIT,
                170,
                100,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        matchingEngine.processOrder(buy);
        matchingEngine.processOrder(sell);

        assertEquals(
                0,
                tradeService.getTrades().size()
        );
    }
}