package ru.example.orders.validation;

import lombok.RequiredArgsConstructor;
import ru.example.orders.exception.OrderNotFoundException;
import ru.example.orders.repository.OrderRepository;
import ru.example.orders.repository.domain.Order;
import ru.example.orders.service.StatusResolver;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

import static ru.example.orders.repository.domain.Status.SHIPPED;

@RequiredArgsConstructor
public class OrderCancelValidator implements ConstraintValidator<OrderCancelConstraint, String> {

	private final OrderRepository orderRepository;
	private final StatusResolver statusResolver;

	@Override
	public boolean isValid(String orderId, ConstraintValidatorContext context) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isEmpty()) throw new OrderNotFoundException();
		return
			!optionalOrder
				.map(order -> order
					.getItems()
					.stream()
					.map(statusResolver::resolveStatus)
					.anyMatch(status -> status == SHIPPED)
				).get();
	}
}
