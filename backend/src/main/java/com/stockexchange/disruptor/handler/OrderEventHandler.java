package com.stockexchange.disruptor.handler;

import com.lmax.disruptor.EventHandler;
import com.stockexchange.model.OrderEvent;

public class OrderEventHandler implements EventHandler<OrderEvent> {

    @Override
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {

        System.out.println("========== ORDER RECEIVED ==========");
        System.out.println("Order ID : " + event.getOrderId());
        System.out.println("Symbol   : " + event.getSymbol());
        System.out.println("Side     : " + event.getSide());
        System.out.println("Type     : " + event.getOrderType());
        System.out.println("Price    : " + event.getPrice());
        System.out.println("Quantity : " + event.getQuantity());

    }
}