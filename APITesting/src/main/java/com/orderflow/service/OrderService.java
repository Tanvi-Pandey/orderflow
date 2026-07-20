package com.orderflow.service;

import com.orderflow.model.Order;
import com.orderflow.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Order updateOrder(Long id, Order updated) {
        Order order = getOrderById(id);
        order.setProductName(updated.getProductName());
        order.setQuantity(updated.getQuantity());
        order.setPrice(updated.getPrice());
        return repository.save(order);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
