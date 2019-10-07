package ru.example.orders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.example.orders.api.OrderAPI;
import ru.example.orders.api.domain.OrderRequest;
import ru.example.orders.repository.domain.Item;
import ru.example.orders.repository.domain.Order;
import ru.example.orders.service.OrderService;
import ru.example.orders.validation.OrderCreateConstraint;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController implements OrderAPI {

	private final OrderService orderService;
	private final ConversionService conversionService;

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Order update(@Valid @RequestBody @OrderCreateConstraint OrderRequest orderRequest) {
		return orderService.save(
			Order.builder()
				.items(getItems(orderRequest))
				.merchantId(orderRequest.getMerchantId())
				.build()
		);
	}

	@Override
	@GetMapping("/{orderId}")
	public Order get(@PathVariable String orderId) {
		return orderService.findById(orderId);
	}

	@Override
	@DeleteMapping("/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String orderId) {
		orderService.delete(orderId);
	}

	@Override
	@PutMapping("/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable String orderId, @RequestBody OrderRequest orderRequest) {
		orderService.update(
			Order.builder()
				.items(getItems(orderRequest))
				.merchantId(orderRequest.getMerchantId())
				.id(orderId)
				.build()
		);
	}

	private List<Item> getItems(@RequestBody OrderRequest orderRequest) {
		return orderRequest
			.getItems()
			.stream()
			.map(itemRequest -> conversionService.convert(itemRequest, Item.class))
			.collect(Collectors.toList());
	}
}
