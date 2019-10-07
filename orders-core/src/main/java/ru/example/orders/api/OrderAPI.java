package ru.example.orders.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.example.orders.api.domain.OrderRequest;
import ru.example.orders.repository.domain.Order;

public interface OrderAPI {
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Order update(@RequestBody OrderRequest orderRequest);

	@GetMapping("/{orderId}")
	Order get(@PathVariable String orderId);

	@DeleteMapping("/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable String orderId);

	@PutMapping("/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@PathVariable String orderId, @RequestBody OrderRequest orderRequest);
}
