package com.stockexchange.orderbook;

import com.stockexchange.enums.OrderSide;
import com.stockexchange.enums.OrderStatus;
import com.stockexchange.enums.OrderType;
import com.stockexchange.model.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MarketDepthServiceTest {

    @Test
    void testMarketDepthAggregation() {

        OrderBook orderBook = new OrderBook();

        Order buy1 = new Order(
                1,
                "AAPL",
                OrderSide.BUY,
                OrderType.LIMIT,
                100,
                50,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        Order buy2 = new Order(
                2,
                "AAPL",
                OrderSide.BUY,
                OrderType.LIMIT,
                100,
                75,
                OrderStatus.OPEN,
                LocalDateTime.now()
        );

        orderBook.getBuyOrderBook().addOrder(buy1);
        orderBook.getBuyOrderBook().addOrder(buy2);

        MarketDepthService service =
                new MarketDepthService(orderBook);

        MarketDepth depth = service.getMarketDepth();

        assertEquals(1, depth.getBids().size());
        assertEquals(125, depth.getBids().get(0).getQuantity());
    }
}