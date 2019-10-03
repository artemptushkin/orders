package ru.example.orders.service;

import ru.example.orders.repository.domain.Order;

public interface OrderService {
	Order findById(String orderId);
}
