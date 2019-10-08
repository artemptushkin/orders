package ru.example.orders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.example.orders.api.domain.MerchantResponse;
import ru.example.orders.controller.domain.MerchantStatusResponse;
import ru.example.orders.controller.domain.OrderStatusResponse;
import ru.example.orders.feign.OrderAPIClient;
import ru.example.orders.repository.domain.Order;
import java.util.stream.Collectors;

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

	@Override
	public MerchantStatusResponse getStatusByMerchantId(Long merchantId) {
		MerchantResponse merchantResponse = orderAPIClient.getMerchantOrders(merchantId);
		return MerchantStatusResponse
			.builder()
			.merchantId(merchantResponse.getMerchantId())
			.orders(
				merchantResponse
					.getOrders()
					.stream()
					.map(order -> conversionService.convert(order, OrderStatusResponse.class))
					.collect(Collectors.toList())
			).build();
	}
}
