package ru.example.orders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.orders.exception.OrderNotFoundException;
import ru.example.orders.repository.OrderRepository;
import ru.example.orders.repository.domain.Order;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	public Order findById(String orderId) {
		return orderRepository
			.findById(orderId)
			.orElseThrow(OrderNotFoundException::new);
	}
}
