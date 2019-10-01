package ru.example.orders.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.example.orders.domain.Item;
import ru.example.orders.domain.Order;
import ru.example.orders.domain.Partition;
import ru.example.orders.repository.OrderRepository;

import java.util.List;

import static ru.example.orders.domain.Status.ORDERED;
import static ru.example.orders.domain.Status.SHIPPED;

@Slf4j
@Component
@Profile("mock")
@RequiredArgsConstructor
public class ApplicationStartedListener {

    private final OrderRepository orderRepository;

    @EventListener
    public void handleContextStart(ApplicationStartedEvent contextStartedEvent) {

        orderRepository.save(
                Order.builder()
                        .merchantId(1L)
                        .orderId(1L)
                        .items(List.of(
                                Item.builder()
                                        .itemId(1L)
                                        .partitions(
                                                List.of(
                                                        Partition.builder()
                                                                .status(SHIPPED)
                                                                .build(),
                                                        Partition.builder()
                                                                .status(ORDERED)
                                                                .build(),
                                                        Partition.builder()
                                                                .status(SHIPPED)
                                                                .build(),
                                                        Partition.builder()
                                                                .status(SHIPPED)
                                                                .build()
                                                )
                                        ).build(),
                                Item.builder()
                                        .itemId(2L)
                                        .partitions(
                                                List.of(
                                                        Partition.builder()
                                                                .status(ORDERED)
                                                                .build(),
                                                        Partition.builder()
                                                                .status(ORDERED)
                                                                .build(),
                                                        Partition.builder()
                                                                .status(ORDERED)
                                                                .build()
                                                )
                                        ).build(),
                                Item.builder()
                                        .itemId(3L)
                                        .partitions(
                                                List.of(
                                                        Partition.builder()
                                                                .status(SHIPPED)
                                                                .build(),
                                                        Partition.builder()
                                                                .status(SHIPPED)
                                                                .build()
                                                )
                                        ).build()
                                )
                        ).build()
        );
        log.info("Saved mock-orders");
    }
}
