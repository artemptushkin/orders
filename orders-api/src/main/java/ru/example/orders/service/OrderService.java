package ru.example.orders.service;

import org.springframework.validation.annotation.Validated;
import ru.example.orders.api.domain.MerchantResponse;
import ru.example.orders.repository.domain.Order;
import ru.example.orders.validation.OrderCancelConstraint;
import javax.validation.Valid;

@Validated
public interface OrderService {
	Order findById(String orderId);

	void delete(@Valid @OrderCancelConstraint String orderId);

	void update(Order order);

	Order save(Order order);

	MerchantResponse findByMerchantId(Long merchantId);
}
