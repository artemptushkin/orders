package ru.example.orders.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Item {
    @Indexed(unique = true)
    private Long itemId;
    @NotEmpty
    private List<Partition> partitions;
    @NotNull
    private String description;

    public Integer getQuantity() {
        if (partitions == null) {
            partitions = new ArrayList<>();
        }
        return partitions.size();
    }
}
