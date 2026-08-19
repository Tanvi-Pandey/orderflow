package com.stockexchange.controller;

import com.stockexchange.model.Order;
import com.stockexchange.service.MatchingEngine;
import com.stockexchange.validation.OrderValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderSubmissionController {

    private final MatchingEngine matchingEngine;
    private final OrderValidator orderValidator;

    public OrderSubmissionController(
            MatchingEngine matchingEngine,
            OrderValidator orderValidator) {

        this.matchingEngine = matchingEngine;
        this.orderValidator = orderValidator;
    }

    @PostMapping
    public ResponseEntity<Order> submitOrder(
            @RequestBody Order order) {

        orderValidator.validate(order);

        matchingEngine.processOrder(order);

        return ResponseEntity.ok(order);
    }
}