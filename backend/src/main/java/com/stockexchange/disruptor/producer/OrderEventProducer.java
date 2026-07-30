package com.stockexchange.disruptor.producer;

import com.lmax.disruptor.RingBuffer;
import com.stockexchange.model.OrderEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderEventProducer {

    private final RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void publishOrder(long orderId,
                             String symbol,
                             String side,
                             String orderType,
                             double price,
                             int quantity) {

        long sequence = ringBuffer.next();

        try {
            OrderEvent event = ringBuffer.get(sequence);

            event.setOrderId(orderId);
            event.setSymbol(symbol);
            event.setSide(side);
            event.setOrderType(orderType);
            event.setPrice(price);
            event.setQuantity(quantity);

        } finally {
            ringBuffer.publish(sequence);
        }
    }
}