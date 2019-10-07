package ru.example.orders.status.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.orders.status.feign.OrderAPIClient;

@RestController
@RequestMapping("/order/status")
@RequiredArgsConstructor
public class StatusController {

	private final OrderAPIClient orderAPIClient;
}
