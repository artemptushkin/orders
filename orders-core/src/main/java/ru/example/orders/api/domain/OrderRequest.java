package ru.example.orders.api.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class OrderRequest {
	@NotEmpty
	private List<ItemRequest> items;
	@Nullable
	@Positive
	private Long merchantId;
}
