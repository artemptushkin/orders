package ru.example.orders.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class OrderControllerAdviser {

	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public void ConstraintViolationException() {}
}
