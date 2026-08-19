package com.stockexchange.controller;

import com.stockexchange.model.Order;
import com.stockexchange.service.MatchingEngine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderSubmissionController {

    private final MatchingEngine matchingEngine;

    public OrderSubmissionController(MatchingEngine matchingEngine) {
        this.matchingEngine = matchingEngine;
    }

    @PostMapping
    public ResponseEntity<Order> submitOrder(
            @RequestBody Order order) {

        matchingEngine.processOrder(order);

        return ResponseEntity.ok(order);
    }
}