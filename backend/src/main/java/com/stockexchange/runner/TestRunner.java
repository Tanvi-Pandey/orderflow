package com.stockexchange.runner;

import com.stockexchange.disruptor.producer.OrderEventProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    private final OrderEventProducer producer;

    public TestRunner(OrderEventProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) {

        producer.publishOrder(
                1L,
                "AAPL",
                "BUY",
                "LIMIT",
                195.50,
                100
        );

        System.out.println("Order Published Successfully!");
    }
}