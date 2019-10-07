package ru.example.orders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.example.orders.controller.domain.OrderRequest;
import ru.example.orders.repository.domain.Item;
import ru.example.orders.repository.domain.Order;
import ru.example.orders.service.OrderService;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	private final ConversionService conversionService;

	@GetMapping("/{orderId}")
	public Order getOrders(@PathVariable String orderId) {
		return orderService.findById(orderId);
	}

	@DeleteMapping("/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String orderId) {
		orderService.delete(orderId);
	}

	@PutMapping("/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable String orderId, @RequestBody OrderRequest orderRequest) {
		orderService.update(
			Order.builder()
				.items(orderRequest
					.getItems()
					.stream()
					.map(itemRequest -> conversionService.convert(itemRequest, Item.class))
					.collect(Collectors.toList())
				)
				.merchantId(orderRequest.getMerchantId())
				.id(orderId)
				.build()
		);
	}
}
