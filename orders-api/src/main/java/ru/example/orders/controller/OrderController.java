package ru.example.orders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.orders.repository.OrderRepository;
import ru.example.orders.repository.domain.Order;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/{orderId}")
    public List<Order> getOrders(@PathVariable Long orderId) {
        return orderRepository.findOrderByOrderId(orderId);
    }
}
