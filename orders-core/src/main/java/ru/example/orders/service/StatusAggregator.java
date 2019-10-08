package ru.example.orders.service;

import org.springframework.stereotype.Component;
import ru.example.orders.repository.domain.Status;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static ru.example.orders.repository.domain.Status.*;

@Component
public class StatusAggregator {

	public Status aggregate(List<Status> statuses) {
		Map<Status, Integer> countersMap = new EnumMap<>(Status.class);
		statuses
			.forEach(status -> {
				Integer counter = countersMap.getOrDefault(status, 0);
				countersMap.put(status, ++counter);
			});

		Integer shipped = countersMap.getOrDefault(SHIPPED, 0);
		Integer leftOrdered = countersMap.getOrDefault(ORDERED, 0);
		Integer partiallyShipped = countersMap.getOrDefault(PARTIALLY_SHIPPED, 0);
		Integer totalStatusesNumber = statuses.size();

		if (partiallyShipped > 0 ) return PARTIALLY_SHIPPED;

		if (shipped > 0) {
			if (shipped < totalStatusesNumber) return PARTIALLY_SHIPPED;
			return SHIPPED;
		}
		if (leftOrdered.equals(totalStatusesNumber) && totalStatusesNumber > 0) return ORDERED;
		return UNKNOWN;
	}
}
