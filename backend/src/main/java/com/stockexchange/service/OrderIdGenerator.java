package com.stockexchange.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class OrderIdGenerator {

    private final AtomicLong counter = new AtomicLong(1);

    public long generate() {
        return counter.getAndIncrement();
    }
}