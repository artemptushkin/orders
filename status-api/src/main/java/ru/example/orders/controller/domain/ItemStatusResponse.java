package ru.example.orders.controller.domain;

import lombok.Builder;
import lombok.Data;
import ru.example.orders.repository.domain.Status;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
public class ItemStatusResponse {
	@Positive
	private Long id;
	@NotNull
	private Status status;
}
