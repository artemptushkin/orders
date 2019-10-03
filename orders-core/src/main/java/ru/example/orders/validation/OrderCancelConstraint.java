package ru.example.orders.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OrderCancelValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderCancelConstraint {
	String message() default "Cancellation of an order is only allowed if no item of it has been already shipped";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
