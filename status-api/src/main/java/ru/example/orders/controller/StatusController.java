package ru.example.orders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.orders.controller.domain.MerchantStatusResponse;
import ru.example.orders.controller.domain.OrderStatusResponse;
import ru.example.orders.service.StatusService;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusController {

	private final StatusService statusService;

	@GetMapping("/order/{orderId}")
	public OrderStatusResponse get(@PathVariable String orderId) {
		return statusService.getStatus(orderId);
	}

	@GetMapping("/merchant/{merchantId}")
	public MerchantStatusResponse getMerchantOrders(@PathVariable Long merchantId) {
		return statusService.getStatusByMerchantId(merchantId);
	}
}
