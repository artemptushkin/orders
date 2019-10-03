package ru.example.orders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.example.orders.exception.OrderNotFoundException;
import ru.example.orders.repository.OrderRepository;
import ru.example.orders.repository.domain.Order;
import ru.example.orders.validation.OrderCancelConstraint;
import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	public Order findById(String orderId) {
		return orderRepository
			.findById(orderId)
			.orElseThrow(OrderNotFoundException::new);
	}

	@Override
	public void delete(@Valid @OrderCancelConstraint String orderId) {
		orderRepository.deleteById(orderId);
	}
}
