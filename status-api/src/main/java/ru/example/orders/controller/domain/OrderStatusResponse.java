package ru.example.orders.controller.domain;

import lombok.Builder;
import lombok.Data;
import ru.example.orders.repository.domain.Status;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class OrderStatusResponse {
	@NotNull
	private String id;
	@NotEmpty
	private List<ItemStatusResponse> items;
	@Positive
	private Long merchantId;
	@NotNull
	private Status status;
}
