package ru.example.orders.controller.domain;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class MerchantStatusResponse {
	@NotEmpty
	private List<OrderStatusResponse> orders;
	@Positive
	private Long merchantId;
}
