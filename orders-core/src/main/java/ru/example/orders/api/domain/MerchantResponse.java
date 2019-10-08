package ru.example.orders.api.domain;

import lombok.Builder;
import lombok.Data;
import ru.example.orders.repository.domain.Order;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class MerchantResponse {
	@NotEmpty
	private List<Order> orders;
	@Positive
	private Long merchantId;
}
