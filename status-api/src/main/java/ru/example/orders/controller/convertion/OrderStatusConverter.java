package ru.example.orders.controller.convertion;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.example.orders.controller.domain.ItemStatusResponse;
import ru.example.orders.controller.domain.OrderStatusResponse;
import ru.example.orders.repository.domain.Order;
import ru.example.orders.service.StatusResolver;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderStatusConverter implements Converter<Order, OrderStatusResponse> {

	private final StatusResolver statusResolver;

	@Override
	public OrderStatusResponse convert(Order order) {
		return OrderStatusResponse
			.builder()
			.id(order.getId())
			.merchantId(order.getMerchantId())
			.status(statusResolver.resolveStatus(order))
			.items(
				order
					.getItems()
					.stream()
					.map(item -> ItemStatusResponse
						.builder()
						.id(item.getId())
						.status(statusResolver.resolveStatus(item))
						.build()
					).collect(Collectors.toList())
			).build();
	}
}
