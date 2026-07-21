package com.stockexchange.disruptor;

import com.lmax.disruptor.EventFactory;
import com.stockexchange.model.OrderEvent;

public class OrderEventFactory implements EventFactory<OrderEvent> {

    @Override
    public OrderEvent newInstance() {
        return new OrderEvent();
    }
}