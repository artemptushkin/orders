package ru.example.orders.status.feign;

import org.springframework.cloud.openfeign.FeignClient;
import ru.example.orders.api.OrderAPI;

@FeignClient(url = "${orders.api.url}", name = "order-api")
public interface OrderAPIClient extends OrderAPI {
}
