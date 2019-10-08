package ru.example.orders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.example.orders.controller.domain.OrderStatusResponse;
import ru.example.orders.feign.OrderAPIClient;
import ru.example.orders.repository.domain.Order;

@Service
@RequiredArgsConstructor
public class DefaultStatusService implements StatusService {
	private final OrderAPIClient orderAPIClient;
	private final ConversionService conversionService;

	@Override
	public OrderStatusResponse getStatus(String orderId) {
		Order order = orderAPIClient.get(orderId);
		return conversionService.convert(order, OrderStatusResponse.class);
	}
}
