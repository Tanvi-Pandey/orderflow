package com.stockexchange.config;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.stockexchange.disruptor.OrderEventFactory;
import com.stockexchange.disruptor.handler.OrderEventHandler;
import com.stockexchange.model.OrderEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class DisruptorConfig {

    private static final int BUFFER_SIZE = 1024;

    @Bean
    public RingBuffer<OrderEvent> ringBuffer() {

        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                new OrderEventFactory(),
                BUFFER_SIZE,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new BlockingWaitStrategy()
        );

        disruptor.handleEventsWith(new OrderEventHandler());

        disruptor.start();

        return disruptor.getRingBuffer();
    }
}