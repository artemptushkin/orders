package ru.example.orders.controller.convertion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.example.orders.api.domain.ItemRequest;
import ru.example.orders.repository.domain.Item;
import ru.example.orders.repository.domain.Partition;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ru.example.orders.repository.domain.Status.ORDERED;

@Component
public class ItemRequestConverter implements Converter<ItemRequest, Item> {

	@Override
	public Item convert(ItemRequest itemRequest) {
		return Item
			.builder()
			.description(itemRequest.getDescription())
			.id(itemRequest.getId())
			.partitions(
				CollectionUtils.isEmpty(itemRequest.getPartitions()) ? IntStream
					.range(0, itemRequest.getOrderedQuantity())
					.mapToObj(value -> Partition.builder().status(ORDERED).build()).collect(Collectors.toList())
					: itemRequest.getPartitions()
			)
			.build();
	}
}
