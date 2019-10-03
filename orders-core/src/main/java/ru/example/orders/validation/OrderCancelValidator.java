package ru.example.orders.validation;

import lombok.RequiredArgsConstructor;
import ru.example.orders.repository.OrderRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class OrderCancelValidator implements ConstraintValidator<OrderCancelConstraint, String> {

   private final OrderRepository orderRepository;

   @Override
   public boolean isValid(String orderId, ConstraintValidatorContext context) {
      return false;
   }
}
