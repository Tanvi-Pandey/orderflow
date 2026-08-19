package com.stockexchange.controller;

import com.stockexchange.exception.OrderNotFoundException;
import com.stockexchange.service.OrderCancellationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderCancellationController {

    private final OrderCancellationService cancellationService;

    public OrderCancellationController(
            OrderCancellationService cancellationService) {

        this.cancellationService = cancellationService;
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> cancelOrder(
            @PathVariable long orderId) {

        boolean cancelled =
                cancellationService.cancelOrder(orderId);

        if (!cancelled) {
            throw new OrderNotFoundException(
                    "Order not found: " + orderId
            );
        }

        return ResponseEntity.ok(
                "Order " + orderId + " cancelled successfully"
        );
    }
}