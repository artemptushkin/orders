package ru.example.orders.api.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;
import ru.example.orders.repository.domain.Partition;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class ItemRequest {
	@NotNull
	private Long id;
	@NotEmpty
	@Nullable
	private List<Partition> partitions;
	@Nullable
	private String description;
	@Positive
	@NotNull
	private Integer orderedQuantity;
}
