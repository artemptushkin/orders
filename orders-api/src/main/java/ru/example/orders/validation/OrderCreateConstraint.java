package ru.example.orders.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OrderCreateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderCreateConstraint {
	String message() default "Order creation is possible only by passing ordered quantity";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
