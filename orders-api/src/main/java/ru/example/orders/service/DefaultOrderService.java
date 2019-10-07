package ru.example.orders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.orders.exception.OrderNotFoundException;
import ru.example.orders.repository.OrderRepository;
import ru.example.orders.repository.domain.Order;
import java.util.function.Function;

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

	@Override
	public void delete(String orderId) {
		orderRepository.deleteById(orderId);
	}

	@Override
	@Transactional
	public void update(Order updatedOrder) {
		Order existedOrder = orderRepository
			.findById(updatedOrder.getId())
			.orElseThrow(OrderNotFoundException::new);
		existedOrder.setItems(updatedOrder.getItems());
		applyIfNotNull(existedOrder::setMerchantId, existedOrder.getMerchantId());
		applyIfNotNull(existedOrder::setItems, existedOrder.getItems());

		orderRepository.save(existedOrder);
	}

	private <T> void applyIfNotNull(Function<T, Order> function, T newValue) {
		if (newValue != null) {
			function.apply(newValue);
		}
	}
}
