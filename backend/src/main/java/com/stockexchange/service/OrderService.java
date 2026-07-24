package com.stockexchange.service;

import com.stockexchange.dto.OrderRequest;
import com.stockexchange.dto.OrderResponse;
import com.stockexchange.enums.OrderStatus;
import com.stockexchange.model.Order;
import com.stockexchange.orderbook.OrderBook;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final AtomicLong orderIdGenerator = new AtomicLong(1);

    private final OrderBook orderBook;
    private final TradeService tradeService;
    private final MatchingEngine matchingEngine;

    public OrderService(TradeService tradeService) {

        this.tradeService = tradeService;

        this.orderBook = new OrderBook();

        this.matchingEngine =
                new MatchingEngine(orderBook, tradeService);
    }

    public OrderResponse placeOrder(OrderRequest request) {

        Order order = new Order();

        order.setOrderId(orderIdGenerator.getAndIncrement());

        order.setSymbol(request.getSymbol());

        order.setSide(request.getSide());

        order.setType(request.getType());

        order.setPrice(request.getPrice());

        order.setQuantity(request.getQuantity());

        order.setStatus(OrderStatus.OPEN);

        order.setTimestamp(LocalDateTime.now());

        matchingEngine.processOrder(order);

        return new OrderResponse(
                order.getOrderId(),
                order.getSymbol(),
                order.getStatus(),
                "Order processed successfully"
        );
    }

    public OrderBook getOrderBook() {
        return orderBook;
    }

    public MatchingEngine getMatchingEngine() {
        return matchingEngine;
    }
}