package ru.example.orders.controller.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;
import ru.example.orders.repository.domain.Item;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class OrderRequest {
	@NotEmpty
	private List<Item> items;
	@Nullable
	@Positive
	private Long merchantId;
}
