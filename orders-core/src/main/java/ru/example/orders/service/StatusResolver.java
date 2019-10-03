package ru.example.orders.service;

import org.springframework.stereotype.Component;
import ru.example.orders.repository.domain.Item;
import ru.example.orders.repository.domain.Partition;
import ru.example.orders.repository.domain.Status;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static ru.example.orders.repository.domain.Status.*;

@Component
public class StatusResolver {

	public Status resolveStatus(Item item) {
		List<Partition> partitions = item.getPartitions();
		Map<Status, Integer> countersMap = new EnumMap<>(Status.class);
		partitions
			.forEach(aItem -> {
				Status status = aItem.getStatus();
				Integer counter = countersMap.getOrDefault(aItem.getStatus(), 0);
				countersMap.put(status, ++counter);
			});

		Integer shipped = countersMap.getOrDefault(SHIPPED, 0);
		Integer leftOrdered = countersMap.getOrDefault(ORDERED, 0);
		Integer ordered = item.getOrderedQuantity();

		if (shipped > 0) {
			if (shipped < ordered) return PARTIALLY_SHIPPED;
			return SHIPPED;
		}
		if (leftOrdered.equals(ordered) && ordered > 0) return ORDERED;
		return UNKNOWN;
	}
}
