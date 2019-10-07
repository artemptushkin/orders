package ru.example.orders.validation;

import ru.example.orders.api.domain.OrderRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.springframework.util.CollectionUtils.isEmpty;

public class OrderCreateValidator implements ConstraintValidator<OrderCreateConstraint, OrderRequest> {

   @Override
   public boolean isValid(OrderRequest orderRequest, ConstraintValidatorContext context) {
      return orderRequest
          .getItems()
          .stream()
          .allMatch(order -> isEmpty(order.getPartitions()));
   }
}
