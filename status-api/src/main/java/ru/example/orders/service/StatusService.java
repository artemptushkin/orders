package ru.example.orders.service;

import ru.example.orders.controller.domain.OrderStatusResponse;

public interface StatusService {
	OrderStatusResponse getStatus(String orderId);
}
