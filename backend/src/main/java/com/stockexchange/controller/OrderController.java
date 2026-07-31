package com.stockexchange.controller;

import com.stockexchange.dto.OrderRequest;
import com.stockexchange.dto.OrderResponse;
import com.stockexchange.orderbook.OrderBook;
import com.stockexchange.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(
            @Valid @RequestBody OrderRequest request) {

        OrderResponse response = orderService.placeOrder(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/book")
    public ResponseEntity<OrderBook> getOrderBook() {

        return ResponseEntity.ok(
                orderService.getOrderBook()
        );
    }
}