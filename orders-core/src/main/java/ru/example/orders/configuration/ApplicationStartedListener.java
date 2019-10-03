package ru.example.orders.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.example.orders.repository.domain.CompositeItem;
import ru.example.orders.repository.domain.Order;
import ru.example.orders.repository.domain.Item;
import ru.example.orders.repository.OrderRepository;

import java.util.List;

import static ru.example.orders.repository.domain.Status.ORDERED;
import static ru.example.orders.repository.domain.Status.SHIPPED;

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
				.id("1")
				.items(List.of(
					CompositeItem.builder()
						.id(1L)
                        .description("wonderful item")
						.partitions(
							List.of(
								Item.builder().status(SHIPPED).build(),
								Item.builder().status(ORDERED).build(),
								Item.builder().status(SHIPPED).build(),
								Item.builder().status(SHIPPED).build()
							)
						).build(),
					CompositeItem.builder()
						.id(2L)
                        .description("useful item")
                        .partitions(
							List.of(
								Item.builder().status(ORDERED).build(),
								Item.builder().status(ORDERED).build(),
								Item.builder().status(ORDERED).build()
							)
						).build(),
					CompositeItem.builder()
						.id(3L)
						.partitions(
							List.of(
								Item.builder().status(SHIPPED).build(),
								Item.builder().status(SHIPPED).build()
							)
						).build()
					)
				).build()
		);
		orderRepository.save(
			Order.builder()
				.merchantId(1L)
				.id("2")
				.items(List.of(
					CompositeItem.builder()
						.id(3L)
						.description("old item")
						.partitions(
							List.of(
								Item.builder().status(SHIPPED).build(),
								Item.builder().status(ORDERED).build(),
								Item.builder().status(SHIPPED).build(),
								Item.builder().status(SHIPPED).build()
							)
						).build(),
					CompositeItem.builder()
						.id(4L)
						.description("very old item")
						.partitions(
							List.of(
								Item.builder().status(ORDERED).build(),
								Item.builder().status(ORDERED).build(),
								Item.builder().status(ORDERED).build()
							)
						).build(),
					CompositeItem.builder()
						.id(3L)
						.partitions(
							List.of(
								Item.builder().status(SHIPPED).build(),
								Item.builder().status(SHIPPED).build()
							)
						).build()
					)
				).build()
		);

		log.info("Saved mock-orders");
	}
}
