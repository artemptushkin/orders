package ru.example.orders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.orders.repository.domain.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StatusResolver {

	private final StatusAggregator statusAggregator;

	public Status resolveStatus(Order order) {
		return statusAggregator.aggregate(
			order.getItems()
				.stream()
				.map(this::resolveStatus)
				.collect(Collectors.toList())
		);
	}

	public Status resolveStatus(Item item) {
		return statusAggregator.aggregate(
			item
				.getPartitions()
				.stream()
				.map(Partition::getStatus)
				.collect(Collectors.toList()));
	}
}
