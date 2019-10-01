package ru.example.orders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.orders.domain.Order;
import ru.example.orders.repository.OrderRepository;

import java.util.Optional;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/{orderId}")
    public Optional<Order> getOrders(@PathVariable Long orderId) {
        return orderRepository.findOrderByOrOrderId(orderId);
    }
}
