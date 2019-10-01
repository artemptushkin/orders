package ru.example.orders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.example.orders.repository.domain.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findOrderByMerchantId(Long merchantId);
    List<Order> findOrderByOrderId(Long merchantId);
}
