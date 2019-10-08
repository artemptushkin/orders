package ru.example.orders.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.example.orders.api.domain.MerchantResponse;
import ru.example.orders.api.domain.OrderRequest;
import ru.example.orders.repository.domain.Order;
import ru.example.orders.validation.OrderCreateConstraint;
import javax.validation.Valid;

public interface OrderAPI {
	@GetMapping(value = "/merchant/{merchantId}/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	MerchantResponse getMerchantOrders(@PathVariable Long merchantId);

	@PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	Order update(@Valid @RequestBody @OrderCreateConstraint OrderRequest orderRequest);

	@GetMapping(value = "/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	Order get(@PathVariable String orderId);

	@DeleteMapping(value = "/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable String orderId);

	@PutMapping(value = "/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@PathVariable String orderId, @RequestBody OrderRequest orderRequest);
}
